package com.forum.WebForum.Service;

import com.forum.WebForum.Iservice.ICustomerAcquisitionBonusCalculationService;
import com.forum.WebForum.Service.predicate.CustomerAcquisitionOrderPredicateClass;
import com.forum.WebForum.Util.BonusUtil;
import com.forum.WebForum.dataProvider.CustomerAcquisitionDistributorData;
import com.forum.WebForum.model.CustomerAcquisitionBonusDetails;
import com.forum.WebForum.model.CustomerAcquisitionLevels;
import com.forum.WebForum.model.CustomerAcquisitionOrder;
import com.forum.WebForum.model.CustomerAcquistionBonusPojo;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomerAcquisitionBonusCalculationService implements ICustomerAcquisitionBonusCalculationService {



    public List<CustomerAcquistionBonusPojo> getCustomerAcquisitionPojoList(List<CustomerAcquisitionOrder> orderList) {


        CustomerAcquisitionOrderPredicateClass orderPredicateClass = new CustomerAcquisitionOrderPredicateClass
                ("Customer Acquisition", 2);

        String level = "level.";
        List<CustomerAcquistionBonusPojo> customerAcquistionBonusPojoList =

                CustomerAcquisitionOrderPredicateClass.filterOrder(orderList, orderPredicateClass).stream().map(x ->
                {
                    CustomerAcquistionBonusPojo customerAcquistionBonusPojo = new CustomerAcquistionBonusPojo();
                    customerAcquistionBonusPojo.setOrderId(x.getOrderId());
                    customerAcquistionBonusPojo.setAmount(x.getAmount());
                    customerAcquistionBonusPojo.setOrder(x);
                    customerAcquistionBonusPojo.setDistributorId(x.getDistributorId());
                    customerAcquistionBonusPojo.setDistributor(CustomerAcquisitionDistributorData.getDistributorMap().get(x.getDistributorId()));
                    customerAcquistionBonusPojo.setBonusPercentage(BonusUtil.customerAcquisitionPropertyMap.get(level
                            .concat(String.valueOf(
                                    customerAcquistionBonusPojo.getDistributor().getLevel()))));
                    customerAcquistionBonusPojo.setLevel(customerAcquistionBonusPojo.getDistributor().getLevel());
                    return customerAcquistionBonusPojo;
                }).collect(Collectors.toList());

        return customerAcquistionBonusPojoList;
    }

    //    public static Map<String, Integer> getLevels(Map<String, String> params) {
//        Map<String, Integer> propertyMap = new HashMap<>();
//        BonusUtil.propertyMap.put("level.1", Integer.parseInt(params.get("level1")));
//        BonusUtil.propertyMap.put("level.2", Integer.parseInt(params.get("level2")));
//        BonusUtil.propertyMap.put("level.3", Integer.parseInt(params.get("level3")));
//        BonusUtil.propertyMap.put("level.4", Integer.parseInt(params.get("level4")));
//        BonusUtil.propertyMap.put("level.5", Integer.parseInt(params.get("level5")));
//
//       return propertyMap;
//    }
    public List<CustomerAcquisitionBonusDetails> setLevels(CustomerAcquisitionLevels levels) throws IOException {
        System.out.println(levels);
        try {
            OutputStream outputStream = new FileOutputStream("CusAcquisitionlevel.properties");
            Properties properties = new Properties();
            String type = "level";

            properties.setProperty(type.concat(".1"), levels.getLevel1());
            properties.setProperty(type.concat(".2"), levels.getLevel2());
            properties.setProperty(type.concat(".3"), levels.getLevel3());
            properties.setProperty(type.concat(".4"), levels.getLevel4());
            properties.setProperty(type.concat(".5"), levels.getLevel5());

            properties.store(outputStream, null);
        } catch (Exception e) {
            System.out.println();
        }

        CustomerAcquisitionBonusCalculationService bonusCalculationService = new CustomerAcquisitionBonusCalculationService();
        Map<String, Integer> propsMap = new HashMap<>();
        propsMap = bonusCalculationService.startProgram();
        return bonusCalculationService.getCustomerAcquistionBonusDetails(BonusUtil.customerAcquisitionOrderList);
    }

    public List<CustomerAcquisitionBonusDetails> getCustomerAcquistionBonusDetails(List<CustomerAcquisitionOrder> orderList) {
        CustomerAcquisitionBonusCalculationService bonusCalculationService = new CustomerAcquisitionBonusCalculationService();

        List<CustomerAcquistionBonusPojo> customerAcquistionBonusPojoList = bonusCalculationService.getCustomerAcquisitionPojoList(orderList);
        List<CustomerAcquisitionBonusDetails> getBonusDetails =
                customerAcquistionBonusPojoList.stream().map(x ->
                {
                    CustomerAcquisitionBonusDetails bonusDetails = new CustomerAcquisitionBonusDetails();
                    bonusDetails.setOrderId(x.getOrderId());
                    bonusDetails.setDistributorId(x.getDistributorId());
                    bonusDetails.setBonusName("Customer Acquisition");
                    bonusDetails.setBonusAmount(x.getAmount() * x.getBonusPercentage() / 100);
                    return bonusDetails;
                }).collect(Collectors.toList());
        return getBonusDetails;
    }

    public static Map<String, Integer> startProgram() throws IOException {
        Properties properties = new Properties();
        InputStream input = new FileInputStream("CusAcquisitionlevel.properties");
        properties.load(input);
        Enumeration keys = properties.propertyNames();
        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            BonusUtil.customerAcquisitionPropertyMap.put(key, Integer.parseInt(properties.getProperty(key)));
        }
        input.close();
        return BonusUtil.customerAcquisitionPropertyMap;
    }
}

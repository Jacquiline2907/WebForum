package com.forum.WebForum.Service;


import com.forum.WebForum.Iservice.IPremiumKitBonusCalculation;
import com.forum.WebForum.Util.BonusUtil;
import com.forum.WebForum.model.PremiumKitBonusReturn;
import com.forum.WebForum.model.PremiumKitDistributorData;
import com.forum.WebForum.model.PremiumKitOrderData;
import com.forum.WebForum.model.PremiumKitPercentage;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;

@Service
public class PremiumKitBonusCalculation implements IPremiumKitBonusCalculation {

    //    To set the Values into the Properties File.
    public PremiumKitBonusReturn  setPercentage(PremiumKitPercentage percentage) throws Exception {

        System.out.println("inside the set percentage");

        System.out.println(percentage);
        try {
            System.out.println("In try");
            OutputStream output = new FileOutputStream("percentage.properties");
            Properties p = new Properties();
                String type = "level";

            p.setProperty(type.concat(".1"), percentage.getL1());
            p.setProperty(type.concat(".2"), percentage.getL2());
            p.setProperty(type.concat(".3"), percentage.getL3());
            p.setProperty(type.concat(".4"), percentage.getL4());
            p.setProperty(type.concat(".5"), percentage.getL5());

            p.store(output, null);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        PremiumKitBonusCalculation pk = new PremiumKitBonusCalculation();

        PremiumKitBonusReturn  bonusReturn= pk.premiumKitBonusCalc();
        return bonusReturn;
    }

    @Override
    public PremiumKitBonusReturn premiumKitBonusCalc() throws Exception {

        Map<String, Integer> propsMap = new HashMap<>();
        propsMap = PremiumKitBonusCalculation.startProgram();
        System.out.println(propsMap);

        List<PremiumKitOrderData> orderList = new ArrayList<>();
        List<PremiumKitDistributorData> distributorData = new ArrayList<>();
        Predicate<PremiumKitOrderData> premiumPredicate = x -> x.getOrderType() == "premium kit";

//List of Orders to process
        orderList.add(new PremiumKitOrderData(12L, new Date(), "premium kit", 778L, 785L, 12659L, "Y", "N"));
        orderList.add(new PremiumKitOrderData(55L, new Date(), "Retail", 778L, 785L, 123L, "N", "Y"));
        orderList.add(new PremiumKitOrderData(55L, new Date(), "premium kit", 778L, 785L, 126L, "N", "Y"));

//        List of Distributors
        distributorData.add(new PremiumKitDistributorData(12659L, "a", 123L, 2, "Y", true, new Date()));
        distributorData.add(new PremiumKitDistributorData(126L, "b", 15L, 2, "Y", true, new Date()));
        distributorData.add(new PremiumKitDistributorData(150L, "c", 15L, 2, "N", true, new Date()));
        distributorData.add(new PremiumKitDistributorData(123L, "d", 1L, 4, "Y", true, new Date()));
        distributorData.add(new PremiumKitDistributorData(15L, "e", 1L, 5, "N", true, new Date()));
        distributorData.add(new PremiumKitDistributorData(1L, "f", 0L, 5, "Y", true, new Date()));

//        BonusUtil.orderList.addAll(orderList);
//        BonusUtil.distributorData.addAll(distributorData);

        distributorData.stream()
                .map(x -> {
                    BonusUtil.distributorMap.put(x.getDistId(), x);
                    BonusUtil.distributorData.add(x);
                    return x;
                })
                .count();

//
//        System.out.println(BonusUtil.distributorMap);
//        System.out.println(BonusUtil.distributorData);
        orderList.stream()
                .map(x -> {
                    BonusUtil.orderMap.put(x.getDistId(), x);
                    BonusUtil.orderList.add(x);
                    return x;
                })
                .count();
     /*  for(OrderData o:orderList){
           BonusUtil.orderMap.put(o.getDistId(),o);
           BonusUtil.orderList.add(o);
       }*/


        PremiumKitBonusReturn  bonusReturn=premiumFilter(premiumPredicate, orderList);
        return bonusReturn;

    }

    //    Filter only the PremiumKit Orders
    @Override
    public PremiumKitBonusReturn premiumFilter(Predicate<PremiumKitOrderData> premiumPredicate, List<PremiumKitOrderData> orderList) {
        System.out.println("it is with in the Premium Only Order Filter");

        List<PremiumKitDistributorData> premiumOnly1 = new ArrayList<>();
        PremiumKitBonusReturn bonusReturn=new PremiumKitBonusReturn();

        for (PremiumKitOrderData i : orderList) {
            if (premiumPredicate.test(i)) {
                PremiumKitDistributorData dd = new PremiumKitDistributorData();

                long distId = i.getDistId();
                String active;
                do {

//                    System.out.println(dd);
                    dd = BonusUtil.distributorFinder(distId);
//                    System.out.println(dd);
                    distId = dd.getSponserId();
                    active = dd.getActive();

                } while (active == "N");
                System.out.println(dd);
                System.out.println("Sponser Level is =>" + dd.getLevel());
                System.out.println("Sponser Level's Percentage is =>" + BonusUtil.propertyMap.get("level." + dd.getLevel()));

                System.out.println("Bonus Amount is =>" + i.getSrp() * BonusUtil.propertyMap.get("level." + dd.getLevel()) / 100);
//                System.out.println("Premium Only is"+premiumOnly1);

                bonusReturn.setOrderId(i.getOrderId());
                bonusReturn.setSponserLevel(dd.getLevel());
                bonusReturn.setSponserId(dd.getDistId());
                bonusReturn.setBonusAmount(i.getSrp() * BonusUtil.propertyMap.get("level." + dd.getLevel()) / 100);


            }
        }



//        System.out.println("Data in Premium only List is");
//        premiumOnly1.stream().forEach(System.out::println);


//        Predicate<DistributorData> findDistData = y -> premiumOnly.stream().allMatch(x -> x.longValue() == y.getDistId());
//
//        distFinder(premiumOnly, findDistData);
//        BonusUtil.propertyMap.clear();
        return bonusReturn;
    }

    @Override
    public void distFinder(List<Long> premiumOnly, Predicate<PremiumKitDistributorData> findDistData) {
        List<Long> dis = new ArrayList<>();
        System.out.println("it is in the distFInder");


//        To find the Sponser Id and store it in the list
        for (PremiumKitDistributorData d : BonusUtil.distributorData) {
            if (findDistData.test(d)) {
                dis.add(d.getSponserId());
                System.out.println(dis);
                PremiumKitDistributorData sponserData = BonusUtil.distributorFinder(d.getSponserId());
                System.out.println(sponserData);
                System.out.println("Sponser Level is =>" + sponserData.getLevel());
                System.out.println("Sponser Level's Percentage is =>" + BonusUtil.propertyMap.get("level." + sponserData.getLevel()));

                BonusUtil.orderList
                        .stream()
                        .filter(x -> x.getDistId() == premiumOnly.get(0))
                        .map(x -> x.getSrp() * BonusUtil.propertyMap.get("level." + d.getLevel()) / 100)
                        .forEach(System.out::println);

            }
        }

    }

    //    It is to read data from the Properties File.
    public static Map<String, Integer> startProgram() throws Exception {
        System.out.println("it is in the Start Program Method");

        Properties p = new Properties();

        File f = new File("percentage.properties");
        InputStream input = new FileInputStream(f);
        p.load(input);
        Enumeration keys = p.propertyNames();
        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            BonusUtil.propertyMap.put(key, Integer.parseInt(p.getProperty(key)));
        }
        input.close();
        return BonusUtil.propertyMap;
    }
}



package com.forum.WebForum.Service;


import com.forum.WebForum.Iservice.IPremiumKitBonusCalculation;
import com.forum.WebForum.Util.BonusUtil;
import com.forum.WebForum.model.DistributorData;
import com.forum.WebForum.model.OrderData;
import com.forum.WebForum.model.Percentage;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;

@Service
public class PremiumKitCalculationIPremiumKit implements IPremiumKitBonusCalculation {

    //    To set the Values into the Properties File.
    public String setPercentage(Percentage percentage) throws Exception {

        System.out.println("inside the set percentage");

        System.out.println(percentage);
        try {
            System.out.println("In try");
            OutputStream output = new FileOutputStream("C:\\Users\\vmuralidharan\\Downloads\\PremiumKitBonus\\PremiumKitBonus\\src\\main\\resources\\percentage.properties");
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

        PremiumKitCalculationIPremiumKit pk = new PremiumKitCalculationIPremiumKit();

        pk.premiumKitBonusCalc();
        return "Properties Set successfully";
    }

    @Override
    public void premiumKitBonusCalc() throws Exception {

        Map<String, Integer> propsMap = new HashMap<>();
        propsMap = PremiumKitCalculationIPremiumKit.startProgram();
        System.out.println(propsMap);

        List<OrderData> orderList = new ArrayList<>();
        List<DistributorData> distributorData = new ArrayList<>();
        Predicate<OrderData> premiumPredicate = x -> x.getOrderType() == "premium kit";

//List of Orders to process
        orderList.add(new OrderData(12L, new Date(), "premium kit", 778L, 785L, 12659L, "Y", "N"));
        orderList.add(new OrderData(55L, new Date(), "Retail", 778L, 785L, 123L, "N", "Y"));
        orderList.add(new OrderData(55L, new Date(), "premium kit", 778L, 785L, 126L, "N", "Y"));

//        List of Distributors
        distributorData.add(new DistributorData(12659L, "a", 123L, 2, "Y", true, new Date()));
        distributorData.add(new DistributorData(126L, "b", 15L, 2, "Y", true, new Date()));
        distributorData.add(new DistributorData(150L, "c", 15L, 2, "N", true, new Date()));
        distributorData.add(new DistributorData(123L, "d", 1L, 4, "Y", true, new Date()));
        distributorData.add(new DistributorData(15L, "e", 1L, 5, "N", true, new Date()));
        distributorData.add(new DistributorData(1L, "f", 0L, 5, "Y", true, new Date()));

//        BonusUtil.orderList.addAll(orderList);
//        BonusUtil.distributorData.addAll(distributorData);

        distributorData.stream()
                .map(x -> {
                    BonusUtil.distributorMap.put(x.getDistId(), x);
                    BonusUtil.distributorData.add(x);
                    return x;
                })
                .count();
        orderList.stream()
                .map(x -> {
                    BonusUtil.orderMap.put(x.getDistId(), x);
                    BonusUtil.orderList.add(x);
                    return x;
                })
                .count();


        premiumFilter(premiumPredicate, orderList);

    }

    //    Filter only the PremiumKit Orders
    @Override
    public void premiumFilter(Predicate<OrderData> premiumPredicate, List<OrderData> orderList) {
        System.out.println("it is with in the Premium Only Order Filter");

        List<DistributorData> premiumOnly1 = new ArrayList<>();



        for (OrderData i : orderList) {
            if (premiumPredicate.test(i)) {
                DistributorData dd = new DistributorData();

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

                System.out.println("Bonus Amount is =>"+i.getSrp()* BonusUtil.propertyMap.get("level." + dd.getLevel()) / 100);
//                System.out.println("Premium Only is"+premiumOnly1);

            }
        }

//        System.out.println("Data in Premium only List is");
//        premiumOnly1.stream().forEach(System.out::println);


//        Predicate<DistributorData> findDistData = y -> premiumOnly.stream().allMatch(x -> x.longValue() == y.getDistId());
//
//        distFinder(premiumOnly, findDistData);
//        BonusUtil.propertyMap.clear();

    }

    @Override
    public void distFinder(List<Long> premiumOnly, Predicate<DistributorData> findDistData) {
        List<Long> dis = new ArrayList<>();
        System.out.println("it is in the distFInder");


//        To find the Sponser Id and store it in the list
        for (DistributorData d : BonusUtil.distributorData) {
            if (findDistData.test(d)) {
                dis.add(d.getSponserId());
                System.out.println(dis);
                DistributorData sponserData = BonusUtil.distributorFinder(d.getSponserId());
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

        File f = new File("C:\\Users\\vmuralidharan\\Downloads\\PremiumKitBonus\\PremiumKitBonus\\src\\main\\resources\\percentage.properties");
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



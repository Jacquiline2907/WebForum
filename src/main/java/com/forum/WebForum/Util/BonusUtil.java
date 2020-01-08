package com.forum.WebForum.Util;


import com.forum.WebForum.dataProvider.CustomerAcquisitionOrderData;
import com.forum.WebForum.model.CustomerAcquisitionOrder;
import com.forum.WebForum.model.PremiumKitDistributorData;
import com.forum.WebForum.model.PremiumKitOrderData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BonusUtil {
    public static Map<String, Integer> premiumKitPropertyMap = new HashMap<>();
    public static Map<Long, PremiumKitOrderData> premiumKitOrderMap = new HashMap<>();
    public static Map<Long, PremiumKitDistributorData> premiumKitDistributorMap = new HashMap<>();
    public static List<PremiumKitOrderData> premiumKitOrderList = new ArrayList<>();
    public static List<PremiumKitDistributorData> premiumKitDistributorData = new ArrayList<>();

    public static Map<String, Integer> customerAcquisitionPropertyMap = new HashMap<>();
    public static List<CustomerAcquisitionOrder> customerAcquisitionOrderList = CustomerAcquisitionOrderData.getOrders();


    public static PremiumKitDistributorData distributorFinder(Long distList){
//        System.out.println(distList);
//        System.out.println(BonusUtil.distributorMap.get(BonusUtil.distributorMap.get(distList).getSponserId()));
        if(distList==1){
            return BonusUtil.premiumKitDistributorMap.get(distList);
        }
        return BonusUtil.premiumKitDistributorMap.get(BonusUtil.premiumKitDistributorMap.get(distList).getSponserId());

    }


}

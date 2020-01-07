package com.forum.WebForum.Util;


import com.forum.WebForum.model.PremiumKitDistributorData;
import com.forum.WebForum.model.PremiumKitOrderData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BonusUtil {
    public static Map<String, Integer> propertyMap = new HashMap<>();
    public static Map<Long, PremiumKitOrderData> orderMap = new HashMap<>();
    public static Map<Long, PremiumKitDistributorData> distributorMap = new HashMap<>();

    public static List<PremiumKitOrderData> orderList = new ArrayList<>();
    public static List<PremiumKitDistributorData> distributorData = new ArrayList<>();

    public static PremiumKitDistributorData distributorFinder(Long distList){
//        System.out.println(distList);
//        System.out.println(BonusUtil.distributorMap.get(BonusUtil.distributorMap.get(distList).getSponserId()));
        if(distList==1){
            return BonusUtil.distributorMap.get(distList);
        }
        return BonusUtil.distributorMap.get(BonusUtil.distributorMap.get(distList).getSponserId());

    }


}

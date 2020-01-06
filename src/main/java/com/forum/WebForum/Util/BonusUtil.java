package com.forum.WebForum.Util;


import com.forum.WebForum.model.DistributorData;
import com.forum.WebForum.model.OrderData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BonusUtil {
    public static Map<String, Integer> propertyMap = new HashMap<>();
    public static Map<Long, OrderData> orderMap = new HashMap<>();
    public static Map<Long, DistributorData> distributorMap = new HashMap<>();

    public static List<OrderData> orderList = new ArrayList<>();
    public static List<DistributorData> distributorData = new ArrayList<>();

    public static DistributorData distributorFinder(Long distList){
//        System.out.println(distList);
//        System.out.println(BonusUtil.distributorMap.get(BonusUtil.distributorMap.get(distList).getSponserId()));
        if(distList==1){
            return BonusUtil.distributorMap.get(distList);
        }
        return BonusUtil.distributorMap.get(BonusUtil.distributorMap.get(distList).getSponserId());

    }


}

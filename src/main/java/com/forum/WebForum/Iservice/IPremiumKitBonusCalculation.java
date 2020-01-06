package com.forum.WebForum.Iservice;


import com.forum.WebForum.model.DistributorData;
import com.forum.WebForum.model.OrderData;
import com.forum.WebForum.model.Percentage;

import java.util.List;
import java.util.function.Predicate;


public interface IPremiumKitBonusCalculation {

    String setPercentage(Percentage percentage) throws Exception;

    void premiumKitBonusCalc() throws Exception;

    void premiumFilter(Predicate<OrderData> premiumPredicate, List<OrderData> orderList);

    void distFinder(List<Long> premiumOnly, Predicate<DistributorData> findDistData);
}

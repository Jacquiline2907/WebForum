package com.forum.WebForum.Iservice;


import com.forum.WebForum.model.PremiumKitDistributorData;
import com.forum.WebForum.model.PremiumKitOrderData;
import com.forum.WebForum.model.PremiumKitPercentage;

import java.util.List;
import java.util.function.Predicate;


public interface IPremiumKitBonusCalculation {

    String setPercentage(PremiumKitPercentage percentage) throws Exception;

    void premiumKitBonusCalc() throws Exception;

    void premiumFilter(Predicate<PremiumKitOrderData> premiumPredicate, List<PremiumKitOrderData> orderList);

    void distFinder(List<Long> premiumOnly, Predicate<PremiumKitDistributorData> findDistData);
}

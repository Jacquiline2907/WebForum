package com.forum.WebForum.Iservice;


import com.forum.WebForum.model.PremiumKitBonusReturn;
import com.forum.WebForum.model.PremiumKitDistributorData;
import com.forum.WebForum.model.PremiumKitOrderData;
import com.forum.WebForum.model.PremiumKitPercentage;

import java.util.List;
import java.util.function.Predicate;


public interface IPremiumKitBonusCalculation {

    PremiumKitBonusReturn setPercentage(PremiumKitPercentage percentage) throws Exception;

    PremiumKitBonusReturn premiumKitBonusCalc() throws Exception;

    PremiumKitBonusReturn premiumFilter(Predicate<PremiumKitOrderData> premiumPredicate, List<PremiumKitOrderData> orderList);

    void distFinder(List<Long> premiumOnly, Predicate<PremiumKitDistributorData> findDistData);
}

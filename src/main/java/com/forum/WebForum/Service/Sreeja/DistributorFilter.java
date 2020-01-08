package com.forum.WebForum.Service.Sreeja;


import com.forum.WebForum.model.DistributorDataNovus;
import com.forum.WebForum.model.OrderNovus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class DistributorFilter implements IDistributorFilter {

    @Autowired
    INoviceBonus noviceBonus;

    @Override
    public List<DistributorDataNovus> getBonusmemberlist(Predicate<DistributorDataNovus> p1, List<DistributorDataNovus> distributorDatumNovuses, List<OrderNovus> orderNovuses) {

        List<DistributorDataNovus> distributorDataNovus1 = new ArrayList<>();
        List<DistributorDataNovus> distributorDataNovus2 = new ArrayList<>();
        List<OrderNovus> bonusorder = new ArrayList<>();

        Predicate<OrderNovus> p2 = x -> ((distributorDatumNovuses.stream().anyMatch(y -> y.getDistributorid().equals(x.getDistributorid()))));
        Predicate<DistributorDataNovus> p3 = x -> ((distributorDatumNovuses.stream().anyMatch(y -> y.getDistributorid().equals(x.getSponserId()))));


        for (OrderNovus j : orderNovuses) {
            if (p2.test(j)) {
//                it is for retrieviong ordered person data
                DistributorDataNovus dd = BonusUtilSreeja.distMap.get(j.getDistributorid());

                if (p1.test(dd)) {

                    distributorDataNovus1.add(dd);
//                    System.out.println("Distributor1 after 1st perdicate hitted======>\n" + distributorDataNovus1);
//                    System.out.println("sponser data is===>");
                    distributorDataNovus2.add(BonusUtilSreeja.getDistDetails(distributorDataNovus1.get(0).getDistributorid()));
//                    distributorData2.add(BonusUtil.distMap.get(distributorData1.get(0).getSponserId()));//
                    System.out.println("bonus Amount applied for distributor id is..." + distributorDataNovus2.get(0).getDistributorid()+"\n"+
                             " sponser level is .....\n" + BonusUtilSreeja.propertyMap.get("sponser." + distributorDataNovus2.get(0).getLevel())
//                           +"\n"+ BonusUtilSreeja.propertyMap
                            + "\nsrp of product....." + j.getSrpofproduct()
                            + "\nfinal Preferred customer bonus amount for sponser is......" +
                            j.getSrpofproduct() * BonusUtilSreeja.propertyMap.get("sponser." + distributorDataNovus2.get(0).getLevel()));
////                    );
                }
            }
        }
        return distributorDataNovus2;
    }

}
//
//

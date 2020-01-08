package com.forum.WebForum.Service.Sreeja;


import com.forum.WebForum.model.BonusDetailNovus;
import com.forum.WebForum.model.BonuspojoNovus;
import com.forum.WebForum.model.DistributorDataNovus;
import com.forum.WebForum.model.OrderNovus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
@SpringBootApplication
public class NoviceBonus implements INoviceBonus {

    @Autowired
    IDistributorFilter distributorFilter;

    public void mainPrgrm() {
        try {
            List<OrderNovus> orderNovusList = new ArrayList<>();
            orderNovusList.add(new OrderNovus("2", "novice", 120.0, 200L));
            orderNovusList.add(new OrderNovus("2s", "", 120.0, 219L));
            orderNovusList.add(new OrderNovus("1f", "novice", 130.0, 119L));
            orderNovusList.add(new OrderNovus("3t", "", 140.0, 449L));

            List<DistributorDataNovus> distdata = new ArrayList();
            distdata.add(new DistributorDataNovus(219L, true, 3, 319L));
            distdata.add(new DistributorDataNovus(119L, true, 1, 449L));
            distdata.add(new DistributorDataNovus(449L, true, 2, 649L));
            distdata.add(new DistributorDataNovus(319L, true, 4, 549L));
            distdata.add(new DistributorDataNovus(549L, true, 5));
            distdata.add(new DistributorDataNovus(649L, true, 4, 549L));

            BonusUtilSreeja.orderlist.addAll(orderNovusList);
            for (DistributorDataNovus i : distdata) {
                BonusUtilSreeja.distMap.put(i.getDistributorid(), i);
            }
            calcBonus(distdata, BonusUtilSreeja.orderlist);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    private static BonuspojoNovus bonuspojoNovus;


    public BonusDetailNovus CAlcBonus(BonuspojoNovus bonuspojoNovus) {

        BonusDetailNovus bonusDetail = new BonusDetailNovus();
        bonusDetail.setBonusCode("novice");
        bonusDetail.setBonusName("novice");
        bonusDetail.setDistId(bonuspojoNovus.getDistributordat().getDistributorid());
        bonusDetail.setBonusAmount(bonuspojoNovus.getOrderNovus().getSrpofproduct() * bonuspojoNovus.getBonuspercentage() / 100);
        System.out.println("bonusDetail" + bonusDetail);
        return bonusDetail;
    }

    public void calcBonus(List<DistributorDataNovus> distdata, List<OrderNovus> orderNovuses) {
        Predicate<DistributorDataNovus> distPredicate = x -> (x.isIsactive() && x.getLevel() == 1);

        List<DistributorDataNovus> bonApplicablelist = distributorFilter.getBonusmemberlist(distPredicate, distdata, BonusUtilSreeja.orderlist);
//        System.out.println("bonApplicablelist " + bonApplicablelist);


    }


}

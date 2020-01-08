package com.forum.WebForum.Service.Sreeja;



import com.forum.WebForum.model.BonusDetailNovus;
import com.forum.WebForum.model.BonuspojoNovus;
import com.forum.WebForum.model.DistributorDataNovus;
import com.forum.WebForum.model.OrderNovus;

import java.util.List;


public interface INoviceBonus {

    BonusDetailNovus CAlcBonus(BonuspojoNovus bonuspojoNovus);
   void calcBonus(List<DistributorDataNovus> distdata, List<OrderNovus> orderNovuses);
    void mainPrgrm();

}

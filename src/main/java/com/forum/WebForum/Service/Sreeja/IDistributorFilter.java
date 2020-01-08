package com.forum.WebForum.Service.Sreeja;



import com.forum.WebForum.model.DistributorDataNovus;
import com.forum.WebForum.model.OrderNovus;

import java.util.List;
import java.util.function.Predicate;

public interface IDistributorFilter {

List<DistributorDataNovus> getBonusmemberlist(Predicate<DistributorDataNovus> p,
                                              List<DistributorDataNovus> distributorDatumNovuses,
                                              List<OrderNovus> orderNovus);
}

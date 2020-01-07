package com.forum.WebForum.Iservice;



import com.forum.WebForum.model.CustomerAcquisitionBonusDetails;
import com.forum.WebForum.model.CustomerAcquisitionLevels;
import com.forum.WebForum.model.CustomerAcquisitionOrder;
import com.forum.WebForum.model.CustomerAcquistionBonusPojo;

import java.io.IOException;
import java.util.List;

public interface ICustomerAcquisitionBonusCalculationService {
    List<CustomerAcquistionBonusPojo> getCustomerAcquisitionPojoList(List<CustomerAcquisitionOrder> orderList);
    List<CustomerAcquisitionBonusDetails> setLevels(CustomerAcquisitionLevels levels) throws IOException;
    List<CustomerAcquisitionBonusDetails> getCustomerAcquistionBonusDetails(List<CustomerAcquisitionOrder> orderList);
}

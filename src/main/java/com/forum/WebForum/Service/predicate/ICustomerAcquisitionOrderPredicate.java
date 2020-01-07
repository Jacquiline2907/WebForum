package com.forum.WebForum.Service.predicate;


import com.forum.WebForum.model.CustomerAcquisitionOrder;

public interface ICustomerAcquisitionOrderPredicate {
    boolean test(CustomerAcquisitionOrder order);
}

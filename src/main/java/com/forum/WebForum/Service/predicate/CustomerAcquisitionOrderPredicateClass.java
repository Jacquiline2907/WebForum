package com.forum.WebForum.Service.predicate;

import com.forum.WebForum.model.CustomerAcquisitionOrder;


import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class CustomerAcquisitionOrderPredicateClass implements ICustomerAcquisitionOrderPredicate {

    private String orderType;
    private int caseCredits;
//    private LocalDate dateOfJoin;
//    private LocalDate dateOfBecomeDistributor;

    public CustomerAcquisitionOrderPredicateClass(String orderType, int caseCredits) {
        this.orderType = orderType;
        this.caseCredits = caseCredits;
    }

    public static List<CustomerAcquisitionOrder> filterOrder(List<CustomerAcquisitionOrder> orderList, ICustomerAcquisitionOrderPredicate orderPredicate) {
        List<CustomerAcquisitionOrder> filteredOrderList = new ArrayList<>();
        for (CustomerAcquisitionOrder i : orderList) {
            if (orderPredicate.test(i)) {
                filteredOrderList.add(i);
            }
        }

        return filteredOrderList;
    }

    @Override
    public boolean test(CustomerAcquisitionOrder order) {
        Period period = Period.between(order.getDateOfJoin(), order.getDateofBecomeDistributor());

        if(order.getOrderType().equals(orderType) && order.getCaseCredits() >= caseCredits &&
                ((period.getDays()<=30 && period.getMonths() == 0) || (period.getMonths() == 1 && period.getDays() == 0)))
            return true;
        else
            return false;
    }
}

package com.forum.WebForum.dataProvider;


import com.forum.WebForum.model.CustomerAcquisitionOrder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerAcquisitionOrderData {

    public static List<CustomerAcquisitionOrder> getOrders() {
        List<CustomerAcquisitionOrder> orderList = new ArrayList<>();

        orderList.add(new CustomerAcquisitionOrder(1L, "Customer Acquisition", 2, 300, LocalDate.of(2019, 01, 17), 2, LocalDate.of(2019, 02, 13)));
        orderList.add(new CustomerAcquisitionOrder(2L, "Customer Acquisition", 1, 600, LocalDate.of(2019, 03, 31), 3, LocalDate.of(2019, 04, 15)));
        orderList.add(new CustomerAcquisitionOrder(3L, "Customer Acquisition", 3, 450, LocalDate.of(2019, 06, 29), 2, LocalDate.of(2019, 07, 31)));
        orderList.add(new CustomerAcquisitionOrder(4L, "Customer Acquisition", 5, 1500, LocalDate.of(2019, 07, 18), 2, LocalDate.of(2019, 8, 15)));
        orderList.add(new CustomerAcquisitionOrder(5L, "Customer Acquisition", 4, 3000, LocalDate.of(2019, 07, 29), 4, LocalDate.of(2019, 8, 28)));
        orderList.add(new CustomerAcquisitionOrder(6L, "Customer Acquisition", 1, 150, LocalDate.of(2019, 8, 29), 2, LocalDate.of(2019, 10, 15)));
        orderList.add(new CustomerAcquisitionOrder(7L, "Customer Acquisition", 2, 1000, LocalDate.of(2019, 9, 20), 2, LocalDate.of(2019, 10, 20)));

        return orderList;
    }
}

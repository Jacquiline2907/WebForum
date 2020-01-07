package com.forum.WebForum.dataProvider;

import com.forum.WebForum.model.CustomerAcquisitionDistributor;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerAcquisitionDistributorData {

    public static List<CustomerAcquisitionDistributor> getDistributor() {
        List<CustomerAcquisitionDistributor> distributorList = new ArrayList<>();
        distributorList.add(new CustomerAcquisitionDistributor(1, 0, 5));
        distributorList.add(new CustomerAcquisitionDistributor(2, 1, 4));
        distributorList.add(new CustomerAcquisitionDistributor(3, 1, 3));
        distributorList.add(new CustomerAcquisitionDistributor(4, 2, 3));
        distributorList.add(new CustomerAcquisitionDistributor(5, 2, 2));

        return distributorList;
    }

    public static Map<Integer, CustomerAcquisitionDistributor> getDistributorMap() {
        Map<Integer, CustomerAcquisitionDistributor> distributorMap = new HashMap<>();
        List<CustomerAcquisitionDistributor> distributorList = CustomerAcquisitionDistributorData.getDistributor();


        for (CustomerAcquisitionDistributor dist : distributorList) {
            distributorMap.put(dist.getDistributorId(), dist);
        }

        return distributorMap;
    }
}

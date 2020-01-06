package com.forum.WebForum.dataProvider;

import com.forum.WebForum.model.CompensationPlans;

import java.util.ArrayList;
import java.util.List;

public class CompenstionPlansData {


    public static List<CompensationPlans> getCompensationPlans() {
         List<CompensationPlans> compensationPlansList = new ArrayList<>();

        compensationPlansList.add(new CompensationPlans(1, "Stairstep"));
        compensationPlansList.add(new CompensationPlans(1, "Unilevel"));
        compensationPlansList.add(new CompensationPlans(1, "Unigen"));
        compensationPlansList.add(new CompensationPlans(1, "Hybrid Unilevel"));
        compensationPlansList.add(new CompensationPlans(1, "Matrix"));
        compensationPlansList.add(new CompensationPlans(1, "Binary"));
        return compensationPlansList;
    }
}
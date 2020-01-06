package com.forum.WebForum.model;

public class CompensationPlans {
    public int planKey;
    public String plans;

    public CompensationPlans(int planKey, String plans) {
        this.planKey = planKey;
        this.plans = plans;
    }

    public int getPlanKey() {
        return planKey;
    }

    public void setPlanKey(int planKey) {
        this.planKey = planKey;
    }

    public String getPlans() {
        return plans;
    }

    public void setPlans(String plans) {
        this.plans = plans;
    }
}

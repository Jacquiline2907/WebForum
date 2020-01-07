package com.forum.WebForum.model;

public class PremiumKitBonusReturn {

    private long orderId;
    private long sponserId;
    private int sponserLevel;
    private double bonusAmount;

    public PremiumKitBonusReturn() {
    }

    public PremiumKitBonusReturn(long orderId, long sponserId, int sponserLevel, double bonusAmount) {
        this.orderId = orderId;
        this.sponserId = sponserId;
        this.sponserLevel = sponserLevel;
        this.bonusAmount = bonusAmount;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getSponserId() {
        return sponserId;
    }

    public void setSponserId(long sponserId) {
        this.sponserId = sponserId;
    }

    public int getSponserLevel() {
        return sponserLevel;
    }

    public void setSponserLevel(int sponserLevel) {
        this.sponserLevel = sponserLevel;
    }

    public double getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(double bonusAmount) {
        this.bonusAmount = bonusAmount;
    }
}

package com.forum.WebForum.model;

public class CustomerAcquisitionBonusDetails {
    public Long orderId;
    public int distributorId;
    public String bonusName;
    public double bonusAmount;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public int getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(int distributorId) {
        this.distributorId = distributorId;
    }

    public String getBonusName() {
        return bonusName;
    }

    public void setBonusName(String bonusName) {
        this.bonusName = bonusName;
    }

    public double getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(double bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    public String toString() {
        return "Order Id : " + getOrderId() + " Distributor Id : " + getDistributorId() + " Bonus Name : " + getBonusName() + " Bonus Amount : " + getBonusAmount();
    }
}

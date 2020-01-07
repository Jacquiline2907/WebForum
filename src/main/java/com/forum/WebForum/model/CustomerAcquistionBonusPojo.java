package com.forum.WebForum.model;



import org.springframework.stereotype.Component;

@Component
public class CustomerAcquistionBonusPojo {

    public Long orderId;
    public int distributorId;
    public int level;
    public int bonusPercentage;
    public double amount;
    public CustomerAcquisitionDistributor distributor;
    public CustomerAcquisitionOrder order;


    public CustomerAcquisitionDistributor getDistributor() {
        return distributor;
    }

    public void setDistributor(CustomerAcquisitionDistributor distributor) {
        this.distributor = distributor;
    }

    public CustomerAcquisitionOrder getOrder() {
        return order;
    }

    public void setOrder(CustomerAcquisitionOrder order) {
        this.order = order;
    }

    public int getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(int distributorId) {
        this.distributorId = distributorId;
    }

    public int getBonusPercentage() {
        return bonusPercentage;
    }

    public void setBonusPercentage(int bonusPercentage) {
        this.bonusPercentage = bonusPercentage;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String toString() {
        return "Distributor id : " + getDistributorId() +
                " Order id : " + getOrderId() +
                " Level : " + getLevel() +
                " Bonus Percentage : " + getBonusPercentage() +
                " Amount : " + getAmount();
    }

}

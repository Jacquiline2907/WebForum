package com.forum.WebForum.model;

import java.time.LocalDate;

public class CustomerAcquisitionOrder {
    private Long orderId;
    private String orderType;
    private int distributorId;
    private double amount;
    private LocalDate dateOfJoin;
    private int caseCredits;
    private LocalDate dateofBecomeDistributor;

    public CustomerAcquisitionOrder(Long orderId, String orderType, int distributorId, double amount, LocalDate dateOfJoin, int caseCredits, LocalDate dateofBecomeDistributor) {
        this.orderId = orderId;
        this.orderType = orderType;
        this.distributorId = distributorId;
        this.amount = amount;
        this.dateOfJoin = dateOfJoin;
        this.caseCredits = caseCredits;
        this.dateofBecomeDistributor = dateofBecomeDistributor;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public int getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(int distributorId) {
        this.distributorId = distributorId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(LocalDate dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    public int getCaseCredits() {
        return caseCredits;
    }

    public void setCaseCredits(int caseCredits) {
        this.caseCredits = caseCredits;
    }

    public LocalDate getDateofBecomeDistributor() {
        return dateofBecomeDistributor;
    }

    public void setDateofBecomeDistributor(LocalDate dateofBecomeDistributor) {
        this.dateofBecomeDistributor = dateofBecomeDistributor;
    }

    public String toString() {
        return "Order ID : " + getOrderId() +
                " Order Type : " + getOrderType() +
                " Distribution id : " + getDistributorId() +
                " Amount : " + getAmount() +
                " Date Of Join : " + getDateOfJoin() +
                " Date of become Distributor : " + getDateofBecomeDistributor() +
                " Case Credits : " + getCaseCredits();
    }
}


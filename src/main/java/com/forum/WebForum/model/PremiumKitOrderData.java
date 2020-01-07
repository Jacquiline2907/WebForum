package com.forum.WebForum.model;

import java.util.Date;

public class PremiumKitOrderData {

    private Long orderId;

    private Date orderDate;

    private String orderType;

    private Long orderValue;

    private Long srp;

    private Long distId;

    private String directOrder;

    private String directRetailOrder;

    public PremiumKitOrderData() {
    }

    public PremiumKitOrderData(Long orderId, Date orderDate, String orderType, Long orderValue, Long srp, Long distId, String directOrder, String directRetailOrder) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderType = orderType;
        this.orderValue = orderValue;
        this.srp = srp;
        this.distId = distId;
        this.directOrder = directOrder;
        this.directRetailOrder = directRetailOrder;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Long getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(Long orderValue) {
        this.orderValue = orderValue;
    }

    public Long getSrp() {
        return srp;
    }

    public void setSrp(Long srp) {
        this.srp = srp;
    }

    public Long getDistId() {
        return distId;
    }

    public void setDistId(Long distId) {
        this.distId = distId;
    }

    public String getDirectOrder() {
        return directOrder;
    }

    public void setDirectOrder(String directOrder) {
        this.directOrder = directOrder;
    }

    public String getDirectRetailOrder() {
        return directRetailOrder;
    }

    public void setDirectRetailOrder(String directRetailOrder) {
        this.directRetailOrder = directRetailOrder;
    }

    @Override
    public String toString() {
        return "OrderData{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", orderType='" + orderType + '\'' +
                ", orderValue=" + orderValue +
                ", srp=" + srp +
                ", distId=" + distId +
                ", directOrder='" + directOrder + '\'' +
                ", directRetailOrder='" + directRetailOrder + '\'' +
                '}';
    }
}

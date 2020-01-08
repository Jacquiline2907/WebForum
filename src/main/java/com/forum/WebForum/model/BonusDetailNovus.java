package com.forum.WebForum.model;


//import org.springframework.data.cassandra.core.mapping.Column;
//import org.springframework.data.cassandra.core.mapping.PrimaryKey;
//import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;

public class BonusDetailNovus {

    private Long bonusId;

    private String bonusCode;

    private Date date;

    private Double bonusAmount;

    private Long bonusPC;

    private String bonusName;

    private Long distId;

    private Long orderId;
    private OrderNovus orderNovus;

    public OrderNovus getOrderNovus() {
        return orderNovus;
    }

    public void setOrderNovus(OrderNovus orderNovus) {
        this.orderNovus = orderNovus;
    }

    public BonusDetailNovus() {
    }


    public BonusDetailNovus(Long bonusId, String bonusCode, Date date, Double bonusAmount, Long bonusPC, String bonusName, Long distId, Long orderId, OrderNovus orderNovus) {
        this.bonusId = bonusId;
        this.bonusCode = bonusCode;
        this.date = date;
        this.bonusAmount = bonusAmount;
        this.bonusPC = bonusPC;
        this.bonusName = bonusName;
        this.distId = distId;
        this.orderId = orderId;
        this.orderNovus = orderNovus;

    }

    public Long getBonusId() {
        return bonusId;
    }

    public void setBonusId(Long bonusId) {
        this.bonusId = bonusId;
    }

    public String getBonusCode() {
        return bonusCode;
    }

    public void setBonusCode(String bonusCode) {
        this.bonusCode = bonusCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(Double bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    public Long getBonusPC() {
        return bonusPC;
    }

    public void setBonusPC(Long bonusPC) {
        this.bonusPC = bonusPC;
    }

    public String getBonusName() {
        return bonusName;
    }

    public void setBonusName(String bonusName) {
        this.bonusName = bonusName;
    }

    public Long getDistId() {
        return distId;
    }

    public void setDistId(Long distId) {
        this.distId = distId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}

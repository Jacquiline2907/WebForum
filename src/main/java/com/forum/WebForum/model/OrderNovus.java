package com.forum.WebForum.model;

public class OrderNovus {


    String orderid;
    String orderdate;
    String ordertype;
    String directretailorder;
    String directorder;
    String ordervalue;
    Double srpofproduct;

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public String getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(String ordertype) {
        this.ordertype = ordertype;
    }

    public String getDirectretailorder() {
        return directretailorder;
    }

    public void setDirectretailorder(String directretailorder) {
        this.directretailorder = directretailorder;
    }

    public String getDirectorder() {
        return directorder;
    }

    public void setDirectorder(String directorder) {
        this.directorder = directorder;
    }

    public String getOrdervalue() {
        return ordervalue;
    }

    public void setOrdervalue(String ordervalue) {
        this.ordervalue = ordervalue;
    }

    public Double getSrpofproduct() {
        return srpofproduct;
    }

    public void setSrpofproduct(Double srpofproduct) {
        this.srpofproduct = srpofproduct;
    }

    Long distributorid;// (holds id of distributor or reference id)


    public OrderNovus() {

    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Long getDistributorid() {
        return distributorid;
    }

    public void setDistributorid(Long distributorid) {
        this.distributorid = distributorid;
    }


    public OrderNovus(String orderid, Long distributorid) {
        this.orderid = orderid;
        this.distributorid = distributorid;

    }

    public OrderNovus(String orderid, Double srpofproduct, Long distributorid) {
        this.orderid = orderid;
        this.srpofproduct = srpofproduct;
        this.distributorid = distributorid;
    }

    public OrderNovus(String orderid, String ordertype, Double srpofproduct, Long distributorid) {
        this.orderid = orderid;
        this.ordertype = ordertype;
        this.srpofproduct = srpofproduct;
        this.distributorid = distributorid;
    }

    public OrderNovus(String orderid, String orderdate, String ordertype, String directretailorder, String directorder, String ordervalue, Double srpofproduct, Long distributorid) {
        this.orderid = orderid;
        this.orderdate = orderdate;
        this.ordertype = ordertype;
        this.directretailorder = directretailorder;
        this.directorder = directorder;
        this.ordervalue = ordervalue;
        this.srpofproduct = srpofproduct;
        this.distributorid = distributorid;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderid='" + orderid + '\'' +
                ", orderdate='" + orderdate + '\'' +
                ", ordertype='" + ordertype + '\'' +
                ", directretailorder='" + directretailorder + '\'' +
                ", directorder='" + directorder + '\'' +
                ", ordervalue='" + ordervalue + '\'' +
                ", srpofproduct=" + srpofproduct +
                ", distributorid=" + distributorid +
                '}';
    }
}
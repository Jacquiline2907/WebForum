package com.forum.WebForum.model;

public class BonuspojoNovus {
    @Override
    public String toString() {
        return "Bonuspojo{" +
                "distributordat=" + distributordat +
                ", order=" + orderNovus +
                ", bonuspercentage=" + bonuspercentage +
                ", distId=" + distId +
                '}';
    }

    DistributorDataNovus distributordat;

    public BonuspojoNovus(DistributorDataNovus distributordat, OrderNovus orderNovus, Integer bonuspercentage, Long distId) {
        this.distributordat = distributordat;
        this.orderNovus = orderNovus;
        this.bonuspercentage = bonuspercentage;
        this.distId = distId;
    }

    public BonuspojoNovus() {
    }



    OrderNovus orderNovus;
    Integer bonuspercentage;
    Long distId;

    public DistributorDataNovus getDistributordat() {
        return distributordat;
    }

    public void setDistributordat(DistributorDataNovus distributordat) {
        this.distributordat = distributordat;
    }

    public OrderNovus getOrderNovus() {
        return orderNovus;
    }

    public void setOrderNovus(OrderNovus orderNovus) {
        this.orderNovus = orderNovus;
    }

    public Integer getBonuspercentage() {
        return bonuspercentage;
    }

    public void setBonuspercentage(Integer bonuspercentage) {
        this.bonuspercentage = bonuspercentage;
    }

    public Long getDistId() {
        return distId;
    }

    public void setDistId(Long distId) {
        this.distId = distId;
    }

}

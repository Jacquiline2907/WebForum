package com.forum.WebForum.model;


public class CustomerAcquisitionDistributor {

    public int distributorId;
    public int sponsorId;
    public int level;

    public CustomerAcquisitionDistributor(int distributorId, int sponsorId, int level) {
        this.distributorId = distributorId;
        this.sponsorId = sponsorId;
        this.level = level;
    }

    public int getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(int distributorId) {
        this.distributorId = distributorId;
    }

    public int getSponsorId() {
        return sponsorId;
    }

    public void setSponsorId(int sponsorId) {
        this.sponsorId = sponsorId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String toString() {
        return "Distributor id : " + getDistributorId() +
                " Sponsor Id : " + getSponsorId() +
                " Level : " + getLevel();
    }
}

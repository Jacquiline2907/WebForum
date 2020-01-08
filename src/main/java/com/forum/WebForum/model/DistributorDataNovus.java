package com.forum.WebForum.model;

import java.util.HashMap;
import java.util.Map;

public class DistributorDataNovus {
    Long distributorid;
    boolean isactive;
    Integer level;
    Long sponserId;
    public static Map<String, Integer> distributormap = new HashMap<>();

    public Long getSponserId() {
        return sponserId;
    }

    public void setSponserId(Long sponserId) {
        this.sponserId = sponserId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public DistributorDataNovus(Long distributorid, boolean isactive, int level) {
        this.distributorid = distributorid;
        this.isactive = isactive;
        this.level = level;
    }

    public Long getDistributorid() {
        return distributorid;
    }

    public void setDistributorid(Long distributorid) {
        this.distributorid = distributorid;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    public DistributorDataNovus() {
    }

    public DistributorDataNovus(Long distributorid, boolean isactive, Integer level, Long sponserId) {
        this.distributorid = distributorid;
        this.isactive = isactive;
        this.level = level;
        this.sponserId = sponserId;
    }



    @Override
    public String toString() {
        return "DistributorData{" +
                "distributorid=" + distributorid +
                ", isactive=" + isactive +
                ", level=" + level +
                ", sponserId=" + sponserId +
                '}';
    }
}

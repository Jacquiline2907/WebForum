package com.forum.WebForum.model;

import java.util.Date;

public class PremiumKitDistributorData {

    private Long distId;

    private String distName;

    private Long sponserId;

    private Integer level;

    private String active;

    private Boolean isWql;

    private Date wqlStartDate;

    public PremiumKitDistributorData() {
    }

    public PremiumKitDistributorData(Long distId, String distName, Long sponserId, Integer level, String active, Boolean isWql, Date wqlStartDate) {
        this.distId = distId;
        this.distName = distName;
        this.sponserId = sponserId;
        this.level = level;
        this.active = active;
        this.isWql = isWql;
        this.wqlStartDate = wqlStartDate;
    }


    public Long getDistId() {
        return distId;
    }

    public void setDistId(Long distId) {
        this.distId = distId;
    }

    public String getDistName() {
        return distName;
    }

    public void setDistName(String distName) {
        this.distName = distName;
    }

    public Long getSponserId() {
        return sponserId;
    }

    public void setSponserId(Long sponserId) {
        this.sponserId = sponserId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Boolean getWql() {
        return isWql;
    }

    public void setWql(Boolean wql) {
        isWql = wql;
    }

    public Date getWqlStartDate() {
        return wqlStartDate;
    }

    public void setWqlStartDate(Date wqlStartDate) {
        this.wqlStartDate = wqlStartDate;
    }

    @Override
    public String toString() {
        return "DistributorData{" +
                "distId=" + distId +
                ", distName='" + distName + '\'' +
                ", sponserId=" + sponserId +
                ", level=" + level +
                ", active='" + active + '\'' +
                ", isWql=" + isWql +
                ", wqlStartDate=" + wqlStartDate +
                '}';
    }
}

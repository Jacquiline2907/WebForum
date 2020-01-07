package com.forum.WebForum.model;


public class CustomerAcquisitionLevels {

   public String level1;
   public String level2;
   public String level3;
   public String level4;
   public String level5;

    public String getLevel1() {
        return level1;
    }

    public void setLevel1(String level1) {
        this.level1 = level1;
    }

    public String getLevel2() {
        return level2;
    }

    public void setLevel2(String level2) {
        this.level2 = level2;
    }

    public String getLevel3() {
        return level3;
    }

    public void setLevel3(String level3) {
        this.level3 = level3;
    }

    public String getLevel4() {
        return level4;
    }

    public void setLevel4(String level4) {
        this.level4 = level4;
    }

    public String getLevel5() {
        return level5;
    }

    public void setLevel5(String level5) {
        this.level5 = level5;
    }

    public String toString()
    {
        return "level 1 : " +level1+
                ", level 2 : " +level2+
                ", level 3 : " +level3+
                ", level 4 : " +level4+
                ", level 5 : " +level5;
    }
}

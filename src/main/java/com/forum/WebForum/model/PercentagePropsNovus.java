package com.forum.WebForum.model;

public class PercentagePropsNovus {
    String  lev1;
    String lev2;
    String lev3;
    String lev4;
    String lev5;

    @Override
    public String toString() {
        return "PercentageProps{" +
                "lev1='" + lev1 + '\'' +
                ", lev2='" + lev2 + '\'' +
                ", lev3='" + lev3 + '\'' +
                ", lev4='" + lev4 + '\'' +
                ", lev5='" + lev5 + '\'' +
                '}';
    }

    public PercentagePropsNovus() {
    }

    public String getLev1() {
        return lev1;
    }

    public void setLev1(String lev1) {
        this.lev1 = lev1;
    }

    public String getLev2() {
        return lev2;
    }

    public void setLev2(String lev2) {
        this.lev2 = lev2;
    }

    public String getLev3() {
        return lev3;
    }

    public void setLev3(String lev3) {
        this.lev3 = lev3;
    }

    public String getLev4() {
        return lev4;
    }

    public void setLev4(String lev4) {
        this.lev4 = lev4;
    }

    public String getLev5() {
        return lev5;
    }

    public void setLev5(String lev5) {
        this.lev5 = lev5;
    }

    public PercentagePropsNovus(String lev1, String lev2, String lev3, String lev4, String lev5) {
        this.lev1 = lev1;
        this.lev2 = lev2;
        this.lev3 = lev3;
        this.lev4 = lev4;
        this.lev5 = lev5;
    }



}

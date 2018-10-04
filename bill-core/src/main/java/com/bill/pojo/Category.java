package com.bill.pojo;

public class Category {
    private String id;
    private String categoryCode;
    private String categoryName;
    private String inOutFlag;
    private Long rate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getInOutFlag() {
        return inOutFlag;
    }

    public void setInOutFlag(String inOutFlag) {
        this.inOutFlag = inOutFlag;
    }

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }

    public Category() {

    }

    public Category(String id, String categoryCode, String categoryName, String inOutFlag, Long rate) {
        this.id = id;
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.inOutFlag = inOutFlag;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", categoryCode='" + categoryCode + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", inOutFlag='" + inOutFlag + '\'' +
                ", rate=" + rate +
                '}';
    }
}

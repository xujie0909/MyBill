package com.bill.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class StreamMoney implements Serializable {
    private String id;
    private String happenTime;
    private String inOutFlag;
    private String somethingDo;
    private String category;
    private BigDecimal money;
    private String payType;
    private String createTime;
    private Date updateTime;

    //数据绑定专用
    private String exCategory;
    //更新/新增标志
    private String flag;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getExCategory() {
        return exCategory;
    }
    public void setExCategory(String exCategory) {
        if(this.category == null && exCategory != null){
            this.category = exCategory;
            return;
        }else if(category != null && exCategory != null && !category.equals(exCategory)){
            this.category = this.category +"；"+exCategory;
            return;
        }else{
            this.exCategory = "";
        }
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHappenTime() {
        return happenTime;
    }

    public void setHappenTime(String happenTime) {
        this.happenTime = happenTime;
    }

    public String getInOutFlag() {
        return inOutFlag;
    }

    public void setInOutFlag(String inOutFlag) {
        this.inOutFlag = inOutFlag;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }


    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getSomethingDo() {
        return somethingDo;
    }

    public void setSomethingDo(String somethingDo) {
        this.somethingDo = somethingDo;
    }

    public StreamMoney(String id, String happenTime, String inOutFlag, String somethingDo, String category, BigDecimal money, String payType, String createTime, Date updateTime, String exCategory) {
        this.id = id;
        this.happenTime = happenTime;
        this.inOutFlag = inOutFlag;
        this.somethingDo = somethingDo;
        this.category = category;
        this.money = money;
        this.payType = payType;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.exCategory = exCategory;
    }

    public StreamMoney() {
        super();
    }

    @Override
    public String toString() {
        return "StreamMoney{" +
                "id='" + id + '\'' +
                ", happenTime=" + happenTime +
                ", inOutFlag='" + inOutFlag + '\'' +
                ", somethingDo='" + somethingDo + '\'' +
                ", category='" + category + '\'' +
                ", money=" + money +
                ", payType='" + payType + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime=" + updateTime +
                ", exCategory='" + exCategory + '\'' +
                '}';
    }
}

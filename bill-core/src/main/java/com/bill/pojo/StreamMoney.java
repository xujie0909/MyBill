package com.bill.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class StreamMoney implements Serializable {
    private String id;
    private Date happenTime;
    private String inOutFlag;
    private String somethingDo;
    private String category;
    private BigDecimal money;
    private String createTime;
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getHappenTime() {
        return happenTime;
    }

    public void setHappenTime(Date happenTime) {
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

    public StreamMoney(String id, Date happendTime, String inOutFlag, String somethingDo, String category, BigDecimal money, String createTime, Date updateTime) {
        this.id = id;
        this.happenTime = happenTime;
        this.inOutFlag = inOutFlag;
        this.somethingDo = somethingDo;
        this.category = category;
        this.money = money;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public StreamMoney() {
        super();
    }

    @Override
    public String toString() {
        return "StreamOfMoney{" +
                "id='" + id + '\'' +
                ", happendTime=" + happenTime +
                ", inOutFlag='" + inOutFlag + '\'' +
                ", somethinDo='" + somethingDo + '\'' +
                ", category='" + category + '\'' +
                ", money=" + money +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}

package com.bill.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class Item implements Serializable {
    private int id;
    private String inOut;
    private String iname;
    private String itags;
    private BigDecimal imoney;
    private String idesc;
    private String itype;
    private Date ictime;
    private Date iutime;

    public String getIdesc() {
        return idesc;
    }

    public void setIdesc(String idesc) {
        this.idesc = idesc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInOut() {
        return inOut;
    }

    public void setInOut(String inOut) {
        this.inOut = inOut;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public String getTags() {
        return itags;
    }

    public void setTags(String itags) {
        this.itags = itags;
    }

    public BigDecimal getImoney() {
        return imoney;
    }

    public void setImoney(BigDecimal imoney) {
        this.imoney = imoney;
    }

    public String getItype() {
        return itype;
    }

    public void setItype(String itype) {
        this.itype = itype;
    }

    public Date getIctime() {
        return ictime;
    }

    public void setIctime(Date ictime) {
        this.ictime = ictime;
    }

    public Date getIutime() {
        return iutime;
    }

    public void setIutime(Date iutime) {
        this.iutime = iutime;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", inOut='" + inOut + '\'' +
                ", iname='" + iname + '\'' +
                ", tags='" + itags + '\'' +
                ", imoney=" + imoney +
                ", idesc='" + idesc + '\'' +
                ", itype='" + itype + '\'' +
                ", ictime='" + ictime + '\'' +
                ", iutime=" + iutime +
                '}';
    }
}

package com.bill.pojo;

public class Tag {
    private int tid;
    private String tname;
    private Long tcount;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Long getTcount() {
        return tcount;
    }

    public void setTcount(Long tcount) {
        this.tcount = tcount;
    }

    public Tag(String tname, Long tcount) {
        this.tname = tname;
        this.tcount = tcount;
    }

    public Tag() {
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", tcount=" + tcount +
                '}';
    }
}

package com.example.word.pojo;
/**
 *分数表
 */

import java.util.Date;

public class Mark {
    private int mid;                //分数序号
    private String stuid;         //学生ID
    private int stuclass;         //学生班级id
    private double mark;      //学生分数
    private Date markdate;  //分数日期
    private int isflag;            //是否发送给家长
    private String remark;   //备注
    private String pnum;      //试卷号

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public int getStuclass() {
        return stuclass;
    }

    public void setStuclass(int stuclass) {
        this.stuclass = stuclass;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public Date getMarkdate() {
        return markdate;
    }

    public void setMarkdate(Date markdate) {
        this.markdate = markdate;
    }

    public int getIsflag() {
        return isflag;
    }

    public void setIsflag(int isflag) {
        this.isflag = isflag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPnum() {
        return pnum;
    }

    public void setPnum(String pnum) {
        this.pnum = pnum;
    }
}

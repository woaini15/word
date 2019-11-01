package com.example.word.pojo;
/**
 *默写表
 */

import java.util.Date;

public class Writea {
    private int writeid;                 //序号
    private int pid;                       //题目号
    private String writeword;      //默写单词
    private int isyes;                    //是否默写正确
    private Date writedate;        //默写日期
    private String stuid;              //学生id
    private int stuclass;              //学生班级id
    private String pnum;             //试卷号

    public int getWriteid() {
        return writeid;
    }

    public void setWriteid(int writeid) {
        this.writeid = writeid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getWriteword() {
        return writeword;
    }

    public void setWriteword(String writeword) {
        this.writeword = writeword;
    }

    public int getIsyes() {
        return isyes;
    }

    public void setIsyes(int isyes) {
        this.isyes = isyes;
    }

    public Date getWritedate() {
        return writedate;
    }

    public void setWritedate(Date writedate) {
        this.writedate = writedate;
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

    public String getPnum() {
        return pnum;
    }

    public void setPnum(String pnum) {
        this.pnum = pnum;
    }
}

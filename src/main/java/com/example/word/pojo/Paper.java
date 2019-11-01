package com.example.word.pojo;
/**
 *试卷表
 */

import java.util.Date;

public class Paper {
    private int pid;                     //题目号
    private String pnum;            //试卷号
    private int wordid;              //单词序号
    private Date pdate;             //试卷日期
    private int classid;              //考试班级
    private String username;    //出题人员

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPnum() {
        return pnum;
    }

    public void setPnum(String pnum) {
        this.pnum = pnum;
    }

    public int getWordid() {
        return wordid;
    }

    public void setWordid(int wordid) {
        this.wordid = wordid;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

package com.example.word.pojo;

/**
 *班级表
 */
public class Theclass {
    private int classid;             //班级编号
    private String classname;  //班级名称
    private int teaid;               //老师序号

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public int getTeaid() {
        return teaid;
    }

    public void setTeaid(int teaid) {
        this.teaid = teaid;
    }
}

package com.example.word.pojo;
/**
 *学生表
 */

import java.util.Date;

public class Students {
    private String stuid;           //学生编号
    private String sname;        //学生姓名
    private String spass;         //学生密码
    private char ssex;            //学生性别
    private String semail;      //学生邮箱
    private int stuclass;        //班级编号
    private String spname;   //家长姓名
    private String spphone;  //家长电话
    private String saddress; //地址

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSpass() {
        return spass;
    }

    public void setSpass(String spass) {
        this.spass = spass;
    }

    public char getSsex() {
        return ssex;
    }

    public void setSsex(char ssex) {
        this.ssex = ssex;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    public int getStuclass() {
        return stuclass;
    }

    public void setStuclass(int stuclass) {
        this.stuclass = stuclass;
    }

    public String getSpname() {
        return spname;
    }

    public void setSpname(String spname) {
        this.spname = spname;
    }

    public String getSpphone() {
        return spphone;
    }

    public void setSpphone(String spphone) {
        this.spphone = spphone;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }
}

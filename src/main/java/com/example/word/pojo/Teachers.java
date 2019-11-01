package com.example.word.pojo;
/**
 *老师表
 */

import java.util.Date;

public class Teachers {
    private int teaid;          //老师序号
    private String tname;   //老师姓名
    private String tpass;     //老师密码
    private String temail;   //老师邮箱

    public int getTeaid() {
        return teaid;
    }

    public void setTeaid(int teaid) {
        this.teaid = teaid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTpass() {
        return tpass;
    }

    public void setTpass(String tpass) {
        this.tpass = tpass;
    }

    public String getTemail() {
        return temail;
    }

    public void setTemail(String temail) {
        this.temail = temail;
    }
}

package com.example.word.service;

import com.example.word.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaperService {
    /**
     * 学生登录
     * @param semail
     * @param sname
     * @param spass
     * @return
     */
    public String findStudentsService(String semail, String sname, String spass);
    /**
     * 查询密码
     * @param stuid
     * @param spass
     * @return
     */
    public int findSpassService(String stuid,String spass);
    /**
     * 更改密码
     * @param stuid
     * @param spass
     * @return
     */
    public int updSpassService(String stuid,String spass);

    /**
     * 根据学号查姓名
     * @param stuid
     * @return
     */
    public String findSnameService(String stuid);
    /**
     * 查询统计图的数据
     * @param stuid
     * @return
     */
    public List<Echars> findEcharsService(String stuid);
    //根据试卷号查询单词
    public List<Paper> findPaperListService(String pnum);
    //根据试卷号查询除单词序号以外的其他字段
    public Paper findPapernameService(String pnum);
    //试卷号查询
    public List<Paper> findPnumService(String stuid);
    //添加默写信息
    public int addWriteaService(Writea wri);
    //添加学生分数
    public int addMarkService(Mark mark);
}

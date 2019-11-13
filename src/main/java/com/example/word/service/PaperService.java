package com.example.word.service;

import com.example.word.pojo.*;

import java.util.List;

public interface PaperService {
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
    //学生姓名
    public String findsnameService(String stuid);
    //查询随机单词
    public List<Worda> findWordaService();
    //添加随机试卷
    public int addPaperService(Paper paper);

}

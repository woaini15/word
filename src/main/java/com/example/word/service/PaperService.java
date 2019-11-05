package com.example.word.service;

import com.example.word.pojo.Mark;
import com.example.word.pojo.Paper;
import com.example.word.pojo.Writea;

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
}

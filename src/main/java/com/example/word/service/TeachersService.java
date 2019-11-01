package com.example.word.service;

import com.example.word.pojo.Mark;
import com.example.word.pojo.Paper;
import com.example.word.pojo.Worda;

import java.util.List;

public interface TeachersService {
    /**
     * 添加试卷
     * @param objPaper
     * @return
     */
    public int addPaperService(Paper objPaper);
    /**
     * 查询所有的单词
     * @param page
     * @param countPage
     * @return
     */
    public List<Worda> findWordaListService(int page,int countPage);

    /**
     * 单词总条数
     * @return
     */
    public int findWordaCountService();

    /**
     * 最近一次试卷
     * @return
     */
    public String MaxPaperNumService();

    /**
     * 查询学生分数
     * @return
     */
    public List<Mark> findMarkListService(int page,int countPage);

    /**
     * 分数总条数
     * @return
     */
    public int findMarkCountService();
}

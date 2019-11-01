package com.example.word.mapper;
import  com.example.word.pojo.Paper;
import  com.example.word.pojo.Mark;
import  com.example.word.pojo.Worda;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface TeachersMapper {
    /**
     * 添加试卷
     * @param objPaper
     * @return
     */
    public int addPaper(Paper objPaper);
    /**
     * 查询所有的单词
     * @param page
     * @param countPage
     * @return
     */
    public List<Worda> findWordaList(@Param("page")int page,@Param("countPage")int countPage);

    /**
     * 单词总条数
     * @return
     */
    public int findWordaCount();

    /**
     * 最近一次试卷
     * @return
     */
    public String MaxPaperNum();

    /**
     * 查询学生分数
     * @return
     */
    public List<Mark> findMarkList(@Param("page")int page,@Param("countPage")int countPage);

    /**
     * 分数总条数
     * @return
     */
    public int findMarkCount();
}

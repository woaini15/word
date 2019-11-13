package com.example.word.mapper;
import  com.example.word.pojo.Paper;
import  com.example.word.pojo.Mark;
import  com.example.word.pojo.Worda;
import  com.example.word.pojo.Students;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper
public interface TeachersMapper {
    public List<Paper> findPaperList(@Param("page")int page,@Param("countPage")int countPage);
    public int findMarkCount();
    public List<Mark> findMarkScore(@Param("pnum")String pnum,@Param("page")int page,@Param("countPage")int countPage);
    //添加
    public int addPaper(Paper objPaper);
    //试卷号最大
    public String MaxPaperNum();
    public List<Worda> findWordaList(@Param("page")int page,@Param("countPage")int countPage);
    public int findWordaCount();
    /**
     * 根据学生Id查找家长电话
     * @param stuid
     * @return
     */
    public Students getStuPhone(@Param("stuid")String stuid);
    public int updMark(Mark objMark);
    public Mark getById(@Param("mid")int mid);
}

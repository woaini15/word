package com.example.word.mapper;

import com.example.word.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaperMapper {
    //学生登录
    public String findStudents(@Param("semail")String semail, @Param("sname")String sname,@Param("spass")String spass);
    //查询密码
    public int findSpass(@Param("stuid")String stuid,@Param("spass")String spass);
    //更改密码
    public int updSpass(@Param("stuid")String stuid,@Param("spass")String spass);
    //根据学号查姓名
    public String findSname(@Param("stuid")String stuid);
    //查询统计图的数据
    public List<Echars> findEchars(@Param("stuid")String stuid);
    //根据试卷号查询单词
    public List<Paper> findPaperList(@Param("pnum")String pnum);
    //根据试卷号查询除单词序号以外的其他字段
    public Paper findPapername(@Param("pnum")String pnum);
    //我的测试试卷号查询
    public List<Paper> findPnum(@Param("stuid")String stuid);
    //添加默写信息
    public int addWritea(Writea wri);
    //添加学生分数
    public int addMark(Mark mark);
    //查询测试分数
    public List<Mark> findTMark(@Param("stuid")String stuid,@Param("page")int page,@Param("countPage")int countPage);
    //查询测试分数总数
    public int countTMark(@Param("stuid")String stuid);
    //测试错题查询
    public List<Writea> findError(@Param("stuid")String stuid,@Param("pnum")String pnum);
    //我的练习试卷号查询
    public List<Paper> findSPnum(@Param("stuid")String stuid);
    //查询随机单词
    public List<Worda> findWorda();
    //添加随机试卷
    public int addPaper(Paper paper);
    //练习错题查询
    public List<Writea> findSError(@Param("stuid")String stuid,@Param("pnum")String pnum);
}

package com.example.word.mapper;

import com.example.word.pojo.Students;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.example.word.pojo.Paper;
import com.example.word.pojo.Writea;
import com.example.word.pojo.Mark;
@Mapper
public interface PaperMapper {
    //学生登录
    public Students findStudents(@Param("semail")String semail, @Param("sname")String sname,@Param("spass")String spass);
    //根据试卷号查询单词
    public List<Paper> findPaperList(@Param("pnum")String pnum);
    //根据试卷号查询除单词序号以外的其他字段
    public Paper findPapername(@Param("pnum")String pnum);
    //试卷号查询
    public List<Paper> findPnum(@Param("stuid")String stuid);
    //添加默写信息
    public int addWritea(Writea wri);
    //添加学生分数
    public int addMark(Mark mark);
}

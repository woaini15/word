package com.example.word.mapper;

import com.example.word.pojo.Echars;
import com.example.word.pojo.Students;
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
}

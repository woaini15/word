package com.example.word.mapper;

import com.example.word.pojo.Students;
import org.apache.ibatis.annotations.Param;

public interface PaperMapper {
    //学生登录
    public Students findStudents(@Param("semail")String semail, @Param("sname")String sname,@Param("spass")String spass);
}

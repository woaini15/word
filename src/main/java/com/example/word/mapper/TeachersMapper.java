package com.example.word.mapper;

import com.example.word.pojo.Students;
import com.example.word.pojo.Teachers;
import com.example.word.pojo.Theclass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeachersMapper {
    //老师登录
    public String findTeachers(@Param("tname")String tname, @Param("tpass")String tpass);
    //学生查询
    public List<Students> findStudentList(@Param("stuid")String stuid, @Param("sname")String sname,
                                          @Param("page")int page, @Param("countPage")int countPage);
    //查询学生总条数
    public int countStudents(@Param("stuid")String stuid, @Param("sname")String sname);
    //学生添加
    public int addStudents(Students student);
    //学生更改
    public int updStudents(Students student);
    //学生更改查询
    public Students getStudents(@Param("stuid")String stuid);
    //学生删除
    public int delStudents(@Param("stuid")String stuid);
    //班级查询
    public List<Theclass> findTheclassList();
    //学生学号查询
    public String findStuid();
}

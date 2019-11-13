package com.example.word.mapper;

import com.example.word.pojo.*;
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
    //班级查询
    public List<Theclass> findTheclass(@Param("page")int page,@Param("countPage")int countPage);
    // 总条数
    public int findTheclassCount();
    //添加班级
    public int addTheclass(Theclass theclass);
    //修改班级
    public int updTheclass(Theclass theclass);
    //删除班级
    public int delTheclass(@Param("classid")int classid);
    //班级根据id查询
    public Theclass findTheclassById(@Param("classid")int classid);
    //老师查询
    public List<Teachers> findTeacher();
    public List<Paper> findPaperList(@Param("page")int page,@Param("countPage")int countPage);
    public int findMarkCount();
    public List<Mark> findMarkScore(@Param("pnum")String pnum, @Param("page")int page, @Param("countPage")int countPage);
    //添加
    public int addPaper(Paper objPaper);
    //试卷号最大
    public String MaxPaperNum();
    public List<Worda> findWordaList(@Param("page")int page, @Param("countPage")int countPage);
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

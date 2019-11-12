package com.example.word.service;

import com.example.word.pojo.Students;
import com.example.word.pojo.Teachers;
import com.example.word.pojo.Theclass;

import java.util.List;

public interface TeachersService {
    /**
     * 老师登录
     * @param tname
     * @param tpass
     * @return
     */
    public String findTeachersService(String tname,String tpass);
    /**
     * 学生查询
     * @param stuid
     * @param sname
     * @param page
     * @param countPage
     * @return
     */
    public List<Students> findStudentListService(String stuid, String sname, int page, int countPage);
    /**
     * 查询学生总条数
     * @param stuid
     * @param sname
     * @return
     */
    public int countStudentsService(String stuid, String sname);
    /**
     * 学生添加
     * @param student
     * @return
     */
    public int addStudentsService(Students student);
    /**
     * 学生更改
     * @param student
     * @return
     */
    public int updStudentsService(Students student);
    /**
     * 学生更改查询
     * @param stuid
     * @return
     */
    public Students getStudentsService(String stuid);
    /**
     * 学生删除
     * @param stuid
     * @return
     */
    public int delStudentsService(String stuid);
    /**
     * 班级查询
     * @return
     */
    public List<Theclass> findTheclassListService();
    /**
     * 学生学号查询
     * @return
     */
    public String findStuidService();
}

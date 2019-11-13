package com.example.word.service;

import com.example.word.pojo.*;

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
    //班级查询
    public List<Theclass> findTheclassService(int page,int countPage);
    // 总条数
    public int findTheclassCountService();
    //添加班级
    public int addTheclassService(Theclass theclass);
    //修改班级
    public int updTheclassService(Theclass theclass);
    //删除班级
    public int delTheclassService(int classid);
    //班级根据id查询
    public Theclass findTheclassByIdService(int classid);
    //老师查询
    public List<Teachers> findTeacherService();
    //添加
    public int addPaperService(Paper objPaper);
    //试卷号最大
    public String MaxPaperNumService();
    public List<Paper> findPaperListService(int page,int countPage);
    public int findMarkCountService();
    public List<Mark> findMarkScoreService(String pnum, int page, int countPage);
    public List<Worda> findWordaListService(int page, int countPage);
    public int findWordaCountService();
    public Students getStuPhoneService(String stuid);
    public int updMarkService(Mark objMark);
    public Mark getByIdService(int mid);
}

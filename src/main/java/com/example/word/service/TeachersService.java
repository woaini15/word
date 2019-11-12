package com.example.word.service;

import com.example.word.pojo.Teachers;
import com.example.word.pojo.Theclass;

import java.util.List;

public interface TeachersService {
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
    public List<Teachers> findTeachersService();
}

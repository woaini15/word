package com.example.word.service.impl;

import com.example.word.mapper.TeachersMapper;
import com.example.word.pojo.Students;
import com.example.word.pojo.Teachers;
import com.example.word.pojo.Theclass;
import com.example.word.service.TeachersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("teachersServiceImpl")
public class TeachersServiceImpl implements TeachersService {
    @Resource
    private TeachersMapper objTeachMapper;
    @Override
    public String findTeachersService(String tname, String tpass){
        return objTeachMapper.findTeachers(tname,tpass);
    }
    @Override
    public List<Students> findStudentListService(String stuid, String sname, int page, int countPage) {
        return objTeachMapper.findStudentList(stuid,sname,page,countPage);
    }

    @Override
    public int countStudentsService(String stuid, String sname) {
        return objTeachMapper.countStudents(stuid,sname);
    }

    @Override
    public int addStudentsService(Students student) {
        return objTeachMapper.addStudents(student);
    }

    @Override
    public int updStudentsService(Students student) {
        return objTeachMapper.updStudents(student);
    }

    @Override
    public Students getStudentsService(String stuid) {
        return objTeachMapper.getStudents(stuid);
    }

    @Override
    public int delStudentsService(String stuid) {
        return objTeachMapper.delStudents(stuid);
    }

    @Override
    public List<Theclass> findTheclassListService() {
        return objTeachMapper.findTheclassList();
    }

    @Override
    public String findStuidService() {
        return objTeachMapper.findStuid();
    }
}

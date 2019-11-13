package com.example.word.service.impl;

import com.example.word.mapper.TeachersMapper;
import com.example.word.pojo.*;
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
    @Override
    public List<Theclass> findTheclassService(int page,int countPage) {
        return objTeachMapper.findTheclass(page,countPage);
    }

    @Override
    public int findTheclassCountService() {
        return objTeachMapper.findTheclassCount();
    }

    @Override
    public int addTheclassService(Theclass theclass) {
        return objTeachMapper.addTheclass(theclass);
    }

    @Override
    public int updTheclassService(Theclass theclass) {
        return objTeachMapper.updTheclass(theclass);
    }

    @Override
    public int delTheclassService(int classid) {
        return objTeachMapper.delTheclass(classid);
    }

    @Override
    public Theclass findTheclassByIdService(int classid) {
        return objTeachMapper.findTheclassById(classid);
    }

    @Override
    public List<Teachers> findTeacherService() {
        return objTeachMapper.findTeacher();
    }
    @Override
    public int addPaperService(Paper objPaper) {
        return objTeachMapper.addPaper(objPaper);
    }

    @Override
    public String MaxPaperNumService() {
        return objTeachMapper.MaxPaperNum();
    }

    @Override
    public List<Paper> findPaperListService(int page,int countPage) {
        return objTeachMapper.findPaperList(page,countPage);
    }
    @Override
    public int findMarkCountService() {
        return objTeachMapper.findMarkCount();
    }

    @Override
    public List<Mark> findMarkScoreService(String pnum, int page, int countPage) {
        return objTeachMapper.findMarkScore(pnum,page,countPage);
    }

    @Override
    public List<Worda> findWordaListService(int page, int countPage) {
        return objTeachMapper.findWordaList(page,countPage);
    }

    @Override
    public int findWordaCountService() {
        return objTeachMapper.findWordaCount();
    }

    @Override
    public Students getStuPhoneService(String stuid) {
        return objTeachMapper.getStuPhone(stuid);
    }

    @Override
    public int updMarkService(Mark objMark) {
        return objTeachMapper.updMark(objMark);
    }

    @Override
    public Mark getByIdService(int mid) {
        return objTeachMapper.getById(mid);
    }
}

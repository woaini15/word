package com.example.word.service.impl;

import com.example.word.pojo.Teachers;
import com.example.word.pojo.Theclass;
import com.example.word.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.word.mapper.TeachersMapper;

import javax.annotation.Resource;
import java.util.List;

@Service("teachersServiceImpl")
public class TeachersServiceImpl implements TeachersService {
    @Resource
    private TeachersMapper objTeachMapper;
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
    public List<Teachers> findTeachersService() {
        return objTeachMapper.findTeachers();
    }
}

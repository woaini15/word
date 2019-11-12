package com.example.word.service.impl;

import com.example.word.mapper.PaperMapper;
import com.example.word.pojo.Echars;
import com.example.word.pojo.Students;
import com.example.word.service.PaperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("paperServiceImpl")
public class PaperServiceImpl implements PaperService {
    @Resource
    private PaperMapper objPaperMapp;
    @Override
    public String findStudentsService(String semail, String sname, String spass){
       return objPaperMapp.findStudents(semail,sname,spass);
    }

    @Override
    public int findSpassService(String stuid, String spass) {
        return objPaperMapp.findSpass(stuid,spass);
    }

    @Override
    public int updSpassService(String stuid, String spass) {
        return objPaperMapp.updSpass(stuid,spass);
    }

    @Override
    public String findSnameService(String stuid) {
        return objPaperMapp.findSname(stuid);
    }

    @Override
    public List<Echars> findEcharsService(String stuid) {
        return objPaperMapp.findEchars(stuid);
    }
}

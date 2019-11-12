package com.example.word.service.impl;

import com.example.word.mapper.PaperMapper;
import com.example.word.pojo.*;
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
    //根据试卷号查询单词
    @Override
    public List<Paper> findPaperListService(String pnum){return objPaperMapp.findPaperList(pnum);}
    //根据试卷号查询除单词序号以外的其他字段
    @Override
    public Paper findPapernameService(String pnum){return objPaperMapp.findPapername(pnum);}
    //试卷号查询
    @Override
    public List<Paper> findPnumService(String stuid){return objPaperMapp.findPnum(stuid);}
    //添加默写信息
    @Override
    public int addWriteaService(Writea wri){return objPaperMapp.addWritea(wri);}
    //添加学生分数
    @Override
    public int addMarkService(Mark mark){return objPaperMapp.addMark(mark);}
}

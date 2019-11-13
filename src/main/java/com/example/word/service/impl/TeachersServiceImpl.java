package com.example.word.service.impl;

import com.example.word.mapper.TeachersMapper;
import com.example.word.pojo.Mark;
import com.example.word.pojo.Paper;
import com.example.word.pojo.Students;
import com.example.word.pojo.Worda;
import com.example.word.service.TeachersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("teachersServiceImpl")
public class TeachersServiceImpl implements TeachersService {
    @Resource
    private TeachersMapper objTeachMapper;

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

package com.example.word.service.impl;

import com.example.word.mapper.TeachersMapper;
import com.example.word.pojo.Mark;
import com.example.word.pojo.Paper;
import com.example.word.pojo.Worda;
import com.example.word.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Worda> findWordaListService(int page, int countPage) {
        return objTeachMapper.findWordaList(page,countPage);
    }

    @Override
    public int findWordaCountService() {
        return objTeachMapper.findMarkCount();
    }

    @Override
    public String MaxPaperNumService() {
        return objTeachMapper.MaxPaperNum();
    }

    @Override
    public List<Mark> findMarkListService(int page, int countPage) {
        return objTeachMapper.findMarkList(page, countPage);
    }

    @Override
    public int findMarkCountService() {
        return objTeachMapper.findMarkCount();
    }
}

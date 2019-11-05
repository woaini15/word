package com.example.word.service.impl;

import com.example.word.pojo.Mark;
import com.example.word.pojo.Paper;
import com.example.word.pojo.Writea;
import com.example.word.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.word.mapper.PaperMapper;

import javax.annotation.Resource;
import java.util.List;

@Service("paperServiceImpl")
public class PaperServiceImpl implements PaperService {
    @Resource
    private PaperMapper objPaperMapper;
    //根据试卷号查询单词
    public List<Paper> findPaperListService(String pnum){return objPaperMapper.findPaperList(pnum);}
    //根据试卷号查询除单词序号以外的其他字段
    public Paper findPapernameService(String pnum){return objPaperMapper.findPapername(pnum);}
    //试卷号查询
    public List<Paper> findPnumService(String stuid){return objPaperMapper.findPnum(stuid);}
    //添加默写信息
    public int addWriteaService(Writea wri){return objPaperMapper.addWritea(wri);}
    //添加学生分数
    public int addMarkService(Mark mark){return objPaperMapper.addMark(mark);}
}

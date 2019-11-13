package com.example.word.service;

import com.example.word.pojo.Mark;
import com.example.word.pojo.Paper;
import com.example.word.pojo.Students;
import com.example.word.pojo.Worda;

import java.util.List;

public interface TeachersService {
    //添加
    public int addPaperService(Paper objPaper);
    //试卷号最大
    public String MaxPaperNumService();
    public List<Paper> findPaperListService(int page,int countPage);
    public int findMarkCountService();
    public List<Mark> findMarkScoreService(String pnum,int page,int countPage);
    public List<Worda> findWordaListService(int page,int countPage);
    public int findWordaCountService();
    public Students getStuPhoneService(String stuid);
    public int updMarkService(Mark objMark);
    public Mark getByIdService(int mid);
}

package com.example.word.controller;

import com.example.word.service.TeachersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.example.word.pojo.Worda;
import java.util.List;
import javax.annotation.Resource;

@Controller
@SessionAttributes("teaname")//放到Session属性列表中，以便这个属性可以跨请求访问
@RequestMapping("/teach")
public class TeacherController {
    @Resource
    private TeachersService service;

    //进入添加试卷页面
    @RequestMapping("/showaddPaper")
    public String showaddPaper() throws Exception {
        return "addPaper";
    }
    //进入查看单词
    @RequestMapping("/showfindWorda")
    public String showfindWorda() throws Exception {
        return "findWorda";
    }
    //进入查看学生分数
    @RequestMapping("/showfindMark")
    public String showfindMark() throws Exception {
        return "findMark";
    }
}

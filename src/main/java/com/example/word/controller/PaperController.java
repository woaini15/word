package com.example.word.controller;

import com.alibaba.fastjson.JSON;
import com.example.word.pojo.Echars;
import com.example.word.pojo.Students;
import com.example.word.pojo.Worda;
import com.example.word.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("stuid")//放到Session属性列表中，以便这个属性可以跨请求访问
@RequestMapping("/paper")
public class PaperController {
    @Autowired
    private PaperService service;

    @RequestMapping("/get")
    public String get() {
        return "log";
    }

    @RequestMapping("/lookstudent")
    public String lookstudent(@ModelAttribute("stuid")String stuid, Model model) {
        String sname=service.findSnameService(stuid);
        model.addAttribute("stu", sname);
        return "studentMain";
    }
    @RequestMapping("/lookupdStuPwd")
    public String lookupdStuPwd() {
        return "updStuPwd";
    }
    @RequestMapping("/findPwd")
    @ResponseBody
    public String findPwd(@ModelAttribute("stuid")String stuid, @RequestParam(value = "spass", required = false) String spass) {
        int count = service.findSpassService(stuid,spass);
        String json = JSON.toJSONString(count);
        return json;
    }
    @RequestMapping("/updPwd")
    @ResponseBody
    public String updPwd(@ModelAttribute("stuid")String stuid, @RequestParam(value = "spass", required = false) String spass) {
        int count = service.updSpassService(stuid,spass);
        String json = JSON.toJSONString(count);
        return json;
    }
    @RequestMapping("/getStudents")
    @ResponseBody
    public String getStudents(@RequestParam(value = "semail", required = false) String semail,
                              @RequestParam(value = "spwd", required = false) String spwd,
                              Model model,HttpSession session) {
        String stud=null;
        if(semail.indexOf("@")!=-1){
            stud = service.findStudentsService(semail,"",spwd);
        }else{
            stud = service.findStudentsService("",semail,spwd);
        }
        model.addAttribute("stuid", stud);
        String json = JSON.toJSONString(stud);
        return json;
    }
    @RequestMapping(value = "/EcharsShow")
    @ResponseBody
    public List<Echars> findEchars(@ModelAttribute("stuid")String stuid) {
        List<Echars> list = service.findEcharsService(stuid);
        return list;
    }
}

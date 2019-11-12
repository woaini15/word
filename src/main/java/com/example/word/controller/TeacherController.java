package com.example.word.controller;

import com.alibaba.fastjson.JSON;
import com.example.word.pojo.Students;
import com.example.word.pojo.Teachers;
import com.example.word.pojo.Theclass;
import com.example.word.service.TeachersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@SessionAttributes("teaname")//放到Session属性列表中，以便这个属性可以跨请求访问
@RequestMapping("/teach")
public class TeacherController {
    @Resource
    private TeachersService service;

    @RequestMapping("/getTeachers")
    @ResponseBody
    public String getTeachers(@RequestParam(value = "tname", required = false) String tname,
                              @RequestParam(value = "tpass", required = false) String tpass,Model model,
                              HttpSession session) {
        String tea = service.findTeachersService(tname, tpass);
        model.addAttribute("teaname",tea);
        String json = JSON.toJSONString(tea);
        return json;
    }

    @RequestMapping("/lookteacher")
    public String lookteacher(@ModelAttribute("teaname")String teaname, Model model) {
        model.addAttribute("name", teaname);
        return "teacherMain";
    }
    @RequestMapping("/lookwordWrite")
    public String lookwordWrite() {
        return "wordWrite";
    }
    @RequestMapping("/lookfindStudent")
    public String lookfindStudent() {
        return "findStudent";
    }
    @RequestMapping("/lookaddStudent")
    public String lookaddStudent(Model model) {
        List<Theclass> list=service.findTheclassListService();
        String stuid=service.findStuidService();
        String no=stuid.substring(0,1);
        int ids=Integer.parseInt(stuid.substring(1,stuid.length()))+1;
        stuid=no+ids;
        model.addAttribute("stuid", stuid);
        model.addAttribute("list", list);
        return "addStudent";
    }
    @RequestMapping("/lookupdStudent")
    public String lookupdStudent(Model model) {
        List<Theclass> list=service.findTheclassListService();
        model.addAttribute("list", list);
        return "updStudent";
    }
    @RequestMapping("/findStudentList")
    @ResponseBody
    public String findStudentList(@RequestParam(value = "stuid", required = false) String stuid,
                                  @RequestParam(value = "sname", required = false) String sname,
                                  @RequestParam(value = "limit", required = false) String limit,
                                  @RequestParam(value = "page", required = false) String page) {
        System.out.println(stuid+","+sname);
        // 获取页面显示的条数
        int pageNum = Integer.parseInt(limit); //pageNum
        // 获取页面当前页
        int currPage = Integer.parseInt(page); //currPage
        // 计算数据库的分页从第几行开始取数
        // 假设每页显示条数为pageNum10条　当前页为第currPage3页　则(3-1)*10=20
        // sql 语句为　　select * from 表    where 条件   limit 20,10
        int pageCount = (currPage - 1) * pageNum;
        List<Students> list=service.findStudentListService(stuid,sname,pageCount,pageNum);
        int sum=service.countStudentsService(stuid,sname);
        String json=JSON.toJSONString(list);
        System.out.println(json);
        String path="{\"code\":0,\"msg\":\"\",\"count\":"+sum+",\"data\":"+json+"}";
        return path;
    }

    @RequestMapping("/addStudent")
    @ResponseBody
    public String addStudent(Students student){
        int count=service.addStudentsService(student);
        String json = JSON.toJSONString(count);
        return json;
    }

    @RequestMapping("/updStudent")
    @ResponseBody
    public String updStudent(Students student){
        int count=service.updStudentsService(student);
        String json = JSON.toJSONString(count);
        return json;
    }

    @RequestMapping("/getupdStudent")
    @ResponseBody
    public String getupdStudent(@RequestParam(value = "stuid", required = false) String stuid){
        Students students=service.getStudentsService(stuid);
        String json = JSON.toJSONString(students);
        return json;
    }

    @RequestMapping("/delStudent")
    @ResponseBody
    public String delStudent(@RequestParam(value = "stuid", required = false) String stuid){
        int count=service.delStudentsService(stuid);
        String json = JSON.toJSONString(count);
        return json;
    }

}

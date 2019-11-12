package com.example.word.controller;

import com.example.word.pojo.Teachers;
import com.example.word.pojo.Theclass;
import com.example.word.service.TeachersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.alibaba.fastjson.JSON;

@Controller
@SessionAttributes("teaname")//放到Session属性列表中，以便这个属性可以跨请求访问
@RequestMapping("/teach")
public class TeacherController {
    @Autowired
    private TeachersService service;
    @RequestMapping("/showadd")
    public String showadd(Model model) {
        return "addClass";
    }
    @RequestMapping("/addClass")
    @ResponseBody
    public Integer addClass(Theclass t) throws Exception {
        int count=service.addTheclassService(t);
        return count;
    }
    @RequestMapping("/delClass")
    @ResponseBody
    public Integer delClass(int id) throws Exception {
        int count=service.delTheclassService(id);
        return count;
    }
    @RequestMapping("/updClass")
    @ResponseBody
    public Integer updClass(Theclass t) throws Exception {
        int count=service.updTheclassService(t);
        return count;
    }
    @RequestMapping("/editClass")
    public String listFlow(int id, Model m) throws Exception {
        Theclass t= service.findTheclassByIdService(id);
        m.addAttribute("t", t);
        return "editClass";
    }

    @RequestMapping("/get")
    public String get(Model model) {
        return "findClass";
    }
    @RequestMapping("/findClass")
    @ResponseBody
    public String listTheclass(Model m, @RequestParam(value = "limit", defaultValue = "0") String limit, @RequestParam(value = "page", defaultValue = "3") String page) throws Exception {
        // 获取页面显示的条数
        int pageNum = Integer.parseInt(limit); // pageSize
        // 获取页面当前页
        int currPage = Integer.parseInt(page); // pageIndex
        // 计算数据库的分页从第几行开始取数
        // 假设每页显示条数为pageNum10条　当前页为第currPage3页　则(3-1)*10=20
        // sql 语句为　　select * from 表 where 条件 limit 20,10
        int pageCount = (currPage - 1) * pageNum;

        List<Theclass> list = service.findTheclassService(pageCount, pageNum);
        // 将list转换成json
        String json = JSON.toJSONString(list);
        // 获取总行数
        int count = service.findTheclassCountService();
        // 拼装layui需要的json格式
        String layuiJson = "{\"code\":0,\"msg\":\"\",\"count\":" + count
                + ",\"data\":" + json + "}";// 转换成layui数据表格的值格式
        return layuiJson;
    }
    //查询老师信息,显示下拉列表数据
    @RequestMapping("/find")
    @ResponseBody
    public String find(){
        List<Teachers> obj=service.findTeachersService();
        String json=JSON.toJSONString(obj);
        return json;
    }
}

package com.example.word.controller;

import com.alibaba.fastjson.JSON;
import com.example.word.pojo.*;
import com.example.word.service.TeachersService;
import com.example.word.util.Sendmss;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @RequestMapping("/showadd")
    public String showadd(Model model) {
        List<Teachers> obj=service.findTeacherService();
        model.addAttribute("obj", obj);
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
        System.out.println("count-->"+count);
        return count;
    }
    @RequestMapping("/editClass")
    public String listFlow(Model m) throws Exception {
        List<Teachers> obj=service.findTeacherService();
        m.addAttribute("obj", obj);
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
    @RequestMapping("/find")
    @ResponseBody
    public String find(int id,Model model) {
        Theclass t= service.findTheclassByIdService(id);
        String json = JSON.toJSONString(t);
        return json;
    }
    //进入添加返回查询试卷号
    @RequestMapping("/showPaper")
    public String showPaper() throws Exception {
        return "findPaper";
    }
    @RequestMapping("/findPaperController")
    @ResponseBody
    public String findPaperController(@RequestParam(value = "limit", required = false) String limit,
                                      @RequestParam(value = "page", required = false) String page) {
        int pageNum = Integer.parseInt(limit); //pageNum
        int currPage = Integer.parseInt(page); //currPage
        int pageCount = (currPage - 1) * pageNum;
        List<Paper> list=service.findPaperListService(pageCount,pageNum);
        int sum=service.findMarkCountService();
        String json=JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd");
        System.out.println(json);
        String path="{\"code\":0,\"msg\":\"\",\"count\":"+sum+",\"data\":"+json+"}";
        return path;
    }
    //进入查看试卷号
    @RequestMapping("/showMark")
    public String showMark() throws Exception {
        return "findMark";
    }
    //进入查看试卷号
    @RequestMapping("/showMarkScore")
    public String showMarkScore() throws Exception {
        return "findStuMark";
    }
    //查询试卷号
    @RequestMapping("/findMarkScoreController")
    @ResponseBody
    public String findMarkScoreController(@RequestParam(value="pnum",required = false)String pnum,@RequestParam(value = "limit", required = false) String limit,
                                          @RequestParam(value = "page", required = false) String page) {
        int pageNum = Integer.parseInt(limit); //pageNum
        int currPage = Integer.parseInt(page); //currPage
        int pageCount = (currPage - 1) * pageNum;
        List<Mark> list=service.findMarkScoreService(pnum,pageCount,pageNum);
        System.out.println(pnum);
        int sum=service.findMarkCountService();
        String json=JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd");
        System.out.println(json);
        String path="{\"code\":0,\"msg\":\"\",\"count\":"+sum+",\"data\":"+json+"}";
        return path;
    }
    @RequestMapping("/showaddPaper")
    public String showaddPaper() throws Exception {
        return "addPaper";
    }
    @RequestMapping("/addPaperController")
    @ResponseBody
    public String addPaperController(@RequestParam(value = "classid", required = false) int classid,
                                     @RequestParam(value = "lengt", required = false) int lengt,
                                     @RequestParam(value = "wordid", required = false) String wordid,
                                     @RequestParam(value = "pdate", required = false) String pdate,
                                     @ModelAttribute("teaname")String teaname) {
        System.out.println(classid);
        System.out.println(lengt);
        System.out.println(wordid);
        System.out.println(pdate);
        System.out.println(teaname);
        SimpleDateFormat sim=new SimpleDateFormat("yyyyMMdd");
        String date=sim.format(new Date());
        String pum=service.MaxPaperNumService();
        if(pum!=null){
            pum=pum.substring(8,pum.length());
        }
        if(pum==null){
            pum="1111";
        }
        int no=Integer.parseInt(pum);
        no++;
        date="T"+date+no;
        System.out.println(date);
        System.out.println(classid);
        System.out.println(pdate);

        String hood=wordid.substring(wordid.indexOf("[")+1,wordid.lastIndexOf("]"));
        String[] leng=new String[lengt];
        leng=hood.split(",");
        Paper par=new Paper();
        par.setPnum(date);
        try {
            par.setPdate(new SimpleDateFormat("yyyy-MM-dd").parse(pdate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        par.setClassid(classid);
        par.setUsername(teaname);
        int count=0;
        for(int i=0;i<leng.length;i++){
            par.setWordid(Integer.parseInt(leng[i]));
            count=service.addPaperService(par);
        }
        String json = JSON.toJSONString(count);
        return json;
    }
    //查询单词表
    @RequestMapping("/findWordaController")
    @ResponseBody
    public String findWordaController(@RequestParam(value = "limit", required = false) String limit,
                                      @RequestParam(value = "page", required = false) String page) {
        int pageNum = Integer.parseInt(limit); //pageNum
        int currPage = Integer.parseInt(page); //currPage
        int pageCount = (currPage - 1) * pageNum;
        List<Worda> list=service.findWordaListService(pageCount,pageNum);
        int sum=service.findWordaCountService();
        String json=JSON.toJSONString(list);
        System.out.println(json);
        String path="{\"code\":0,\"msg\":\"\",\"count\":"+sum+",\"data\":"+json+"}";
        return path;
    }
    //发送短信
    @RequestMapping("/sendMark")
    @ResponseBody
    public int sendMark(Mark mark) throws Exception {
        int count=0;
        if(mark!=null){
            System.out.println(mark.getMid());
            Sendmss sendmss=new Sendmss();
            Mark mark1=service.getByIdService(mark.getMid());
            System.err.println("---->"+mark.getStuid());
            Students student=service.getStuPhoneService(mark1.getStuid());
            System.err.println("---->"+student.getSpphone());
            System.err.println("---->"+student.getSpphone());
            sendmss.sendSms2(student.getSpphone(),student.getSname(),mark1.getMark()*100);
            count= service.updMarkService(mark);
        }
        return count;
    }
}

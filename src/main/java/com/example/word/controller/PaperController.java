package com.example.word.controller;

import com.alibaba.fastjson.JSON;
import com.example.word.pojo.*;
import com.example.word.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
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
    @RequestMapping("/lookfindByid")
    public String lookfindByid(@ModelAttribute("stuid")String stuid, Model model) {
        String sname=service.findSnameService(stuid);
        model.addAttribute("stu", sname);
        return "findByidStuMark";
    }
    @RequestMapping("/lookError")
    public String lookError(@ModelAttribute("stuid")String stuid,@RequestParam(value = "pnum", required = false) String pnum,Model model) {
        String sname=service.findSnameService(stuid);
        model.addAttribute("sname", sname);
        model.addAttribute("pnum", pnum);
        return "findError";
    }
    @RequestMapping("/lookSError")
    public String lookSError(@ModelAttribute("stuid")String stuid,@RequestParam(value = "pnum", required = false) String pnum,Model model) {
        String sname=service.findSnameService(stuid);
        model.addAttribute("sname", sname);
        model.addAttribute("pnum", pnum);
        return "findsError";
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
    @RequestMapping("/findPaperMark")
    public String findPaperMark(@ModelAttribute("stuid")String stuid,Model model) {
        String sname=service.findSnameService(stuid);
        model.addAttribute("sname", sname);
        return "findPaperMark";
    }
    @RequestMapping("/getPaperlist")
    public String getPaperlist(@ModelAttribute("stuid")String stuid,@RequestParam(value = "pnum", required = false) String pnum,Model model) {
        Paper per = service.findPapernameService(pnum);
        model.addAttribute("per", per);
        String sname=service.findSnameService(stuid);
        model.addAttribute("sname", sname);
        return "findPaperMark2";
    }
    @RequestMapping("/findSpnum")
    public String findSpnum(@ModelAttribute("stuid")String stuid,Model model) {
        String sname=service.findSnameService(stuid);
        model.addAttribute("sname", sname);
        return "findSpnum";
    }
    @RequestMapping("/getWordalist")
    @ResponseBody
    public String getWordaList(@RequestParam(value = "pnum", required = false) String pnum,Model model,HttpSession session) {
        List<Paper> list = service.findPaperListService(pnum);
        model.addAttribute("list", list);
        String json = JSON.toJSONString(list);
        return json;
    }
    @RequestMapping("/getPnum")
    @ResponseBody
    public String getPnum(@ModelAttribute("stuid")String stuid, HttpSession session) {
        List<Paper> list=service.findPnumService(stuid);
        String json = JSON.toJSONString(list);
        return json;
    }
    @RequestMapping("/getSPnum")
    @ResponseBody
    public String getSPnum(@ModelAttribute("stuid")String stuid, HttpSession session) {
        List<Paper> list=service.findSPnumService(stuid);
        String json = JSON.toJSONString(list);
        return json;
    }

    @RequestMapping("/getfen")
    public String getfen(@RequestParam(value = "pnum", required = false) String pnum,
                         @RequestParam(value = "classid", required = false) int classid,
                         @RequestParam(value = "pid", required = false) int[] pid,
                         @RequestParam(value = "word", required = false) String[] word,
                         @ModelAttribute("stuid")String stuid, HttpSession session) {
        List<Paper> list = service.findPaperListService(pnum);
        Writea writ=new Writea();
        Mark marks=new Mark();
        int i=0;
        float count=0;
        String wordd=null;
        for (Paper paper : list) {
            for (Worda worda : paper.getWorda()) {
                wordd=worda.getWord();
            }
            //1是正确，0是错误
            if(wordd.equals(word[i])){
                writ.setIsyes(1);
                count++;
            }else{
                writ.setIsyes(0);
            }
            writ.setPid(pid[i]);
            writ.setWriteword(word[i]);
            writ.setWritedate(new Date());
            writ.setStuid(stuid);
            writ.setStuclass(classid);
            writ.setPnum(pnum);
            service.addWriteaService(writ);
            i++;
        }
        DecimalFormat df = new DecimalFormat("#.##");
        marks.setStuid(stuid);
        marks.setStuclass(classid);
        marks.setMark(Double.parseDouble(df.format(count/word.length)));
        marks.setMarkdate(new Date());
        marks.setIsflag(0);
        marks.setPnum(pnum);
        service.addMarkService(marks);
        return "redirect:lookstudent";
    }
    @RequestMapping("/findTMark")
    @ResponseBody
    public String findTMark(@ModelAttribute("stuid")String stuid,
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
        List<Mark> list=service.findTMarkService(stuid,pageCount,pageNum);
        int sum=service.countTMarkService(stuid);
        String json = JSON.toJSONStringWithDateFormat(list,"yyyy-MM-dd");
        System.out.println(json);
        String path="{\"code\":0,\"msg\":\"\",\"count\":"+sum+",\"data\":"+json+"}";
        return path;
    }
    @RequestMapping("/getdError")
    @ResponseBody
    public String getdError(@ModelAttribute("stuid")String stuid,@RequestParam(value = "pnum", required = false) String pnum,Model model){
        List<Writea> list=service.findErrorService(stuid, pnum);
        String json =JSON.toJSONString(list);
        System.out.println(json);
        return json;
    }
    //随机查询单词
    @RequestMapping("/findWorda")
    @ResponseBody
    public String findWorda(@RequestParam(value = "pnum", required = false) String pnum){
        List<Worda> list=service.findWordaService();
        String json = JSON.toJSONString(list);
        Paper paper =new Paper();

        paper.setPnum(pnum);
        paper.setPdate(new Date());
        for(int i=0;i<list.size();i++){
            paper.setWordid(list.get(i).getWordid());
            service.addPaperService(paper);
        }
        return json;
    }

    @RequestMapping("/findWriteas")
    public String findWriteas(@ModelAttribute("stuid")String stuid,Model model) {
        model.addAttribute("stuid", stuid);
        return "findWritea";
    }
}

package com.example.word.controller;
import java.text.ParseException;

import com.example.word.pojo.Students;
import com.example.word.service.TeachersService;
import com.example.word.util.Sendmss;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.example.word.pojo.Worda;
import com.example.word.pojo.Paper;
import com.example.word.pojo.Mark;
import java.util.Date;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSON;
import java.util.List;
import javax.annotation.Resource;
@Controller
@SessionAttributes("teaname")//放到Session属性列表中，以便这个属性可以跨请求访问
@RequestMapping("/teach")
public class TeacherController {
    @Resource
    private TeachersService service;
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
            sendmss.sendSms2(student.getSpphone(),student.getSname(),mark1.getMark());
            count= service.updMarkService(mark);
        }
        return count;
    }

}

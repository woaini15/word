package com.example.word.controller;

import com.example.word.pojo.*;
import com.example.word.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes("stuid")//放到Session属性列表中，以便这个属性可以跨请求访问
@RequestMapping("/paper")
public class PaperController {
    @Autowired
    private PaperService service;
    @RequestMapping("/get")
    public String get(Model model) {
        String sname=service.findsnameService("T101");
        model.addAttribute("sname", sname);
        model.addAttribute("stuid", "T101");
        return "studentMain";
    }
    @RequestMapping("/findPaperMark")
    public String findPaperMark(Model model) {
        String sname=service.findsnameService("T101");
        model.addAttribute("sname", sname);
        model.addAttribute("stuid", "T101");
        return "findPaperMark";
    }
    @RequestMapping("/getPaperlist")
    public String getPaperlist(@RequestParam(value = "pnum", required = false) String pnum,Model model) {
        Paper per = service.findPapernameService(pnum);
        model.addAttribute("per", per);
        String sname=service.findsnameService("T101");
        model.addAttribute("sname", sname);
        return "findPaperMark2";
    }
    @RequestMapping("/getWordalist")
    @ResponseBody
    public String getWordaList(@RequestParam(value = "pnum", required = false) String pnum,Model model,HttpSession session) {
        List<Paper> list = service.findPaperListService(pnum);
        model.addAttribute("list", list);
        model.addAttribute("stuid", "T101");
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
        return "center";
    }
    //随机查询单词
    @RequestMapping("/findWorda")
    @ResponseBody
    public String findWorda(){
        List<Worda> list=service.findWordaService();
        String json = JSON.toJSONString(list);
        return json;
    }

    @RequestMapping("/findWritea")
    public String findWritea(Model model) {

        return "findWritea";
    }

}

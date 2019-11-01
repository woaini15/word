package com.example.word.controller;

import com.example.word.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("stuid")//放到Session属性列表中，以便这个属性可以跨请求访问
@RequestMapping("/paper")
public class PaperController {
    @Autowired
    private PaperService service;
}

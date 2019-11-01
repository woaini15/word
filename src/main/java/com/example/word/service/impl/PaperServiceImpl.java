package com.example.word.service.impl;

import com.example.word.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.word.mapper.PaperMapper;

import javax.annotation.Resource;

@Service("paperServiceImpl")
public class PaperServiceImpl implements PaperService {
    @Resource
    private PaperMapper objPaperMapper;
}

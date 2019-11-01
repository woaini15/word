package com.example.word.service.impl;

import com.example.word.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("paperServiceImpl")
public class PaperServiceImpl implements PaperService {
    @Autowired
    private PaperService objPaperMapper;
}

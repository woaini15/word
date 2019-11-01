package com.example.word.service.impl;

import com.example.word.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("teachersServiceImpl")
public class TeachersServiceImpl implements TeachersService {
    @Autowired
    private TeachersService objTeachMapper;
}

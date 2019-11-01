package com.example.word.service.impl;

import com.example.word.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.word.mapper.TeachersMapper;

import javax.annotation.Resource;

@Service("teachersServiceImpl")
public class TeachersServiceImpl implements TeachersService {
    @Resource
    private TeachersMapper objTeachMapper;
}

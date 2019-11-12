package com.example.word.mapper;

import com.example.word.pojo.Theclass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeachersMapper {
    //班级查询
    public List<Theclass> findTheclass(@Param("page")int page,@Param("countPage")int countPage);
    // 总条数
    public int findTheclassCount();
    //添加班级
    public int addTheclass(Theclass theclass);
    //修改班级
    public int updTheclass(Theclass theclass);
    //删除班级
    public int delTheclass(@Param("classid")int classid);
    //班级根据id查询
    public Theclass findTheclassById(@Param("classid")int classid);
}

package com.example.word.service;

import com.example.word.pojo.Echars;
import com.example.word.pojo.Students;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaperService {
    /**
     * 学生登录
     * @param semail
     * @param sname
     * @param spass
     * @return
     */
    public String findStudentsService(String semail, String sname, String spass);
    /**
     * 查询密码
     * @param stuid
     * @param spass
     * @return
     */
    public int findSpassService(String stuid,String spass);
    /**
     * 更改密码
     * @param stuid
     * @param spass
     * @return
     */
    public int updSpassService(String stuid,String spass);

    /**
     * 根据学号查姓名
     * @param stuid
     * @return
     */
    public String findSnameService(String stuid);
    /**
     * 查询统计图的数据
     * @param stuid
     * @return
     */
    public List<Echars> findEcharsService(String stuid);
}

package com.baizhi.controller;

import com.baizhi.entity.Teacher;
import com.baizhi.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by yanyan on 2017/6/12.
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Resource
    private TeacherService teacherService;
    /**
     * 查所有
     */
    @RequestMapping("/queryAllTeacher")
    @ResponseBody
    public Map queryAllTeacher(Integer page,Integer rows){
        Map map = teacherService.queryTeacherByPage(page, rows);
        return map;
    }
    /**
     * 查所有
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public List<Teacher> queryAll(){
        List<Teacher> teachers = teacherService.queryAll();
        return teachers;
    }

    /**
     * 查一个
     */
    @RequestMapping("/queryById")
    @ResponseBody
    public Teacher queryById(String id){
        Teacher teacher = teacherService.queryById(id);
        return teacher;
    }
    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    public void delete(String id){
        teacherService.delete(id);
    }
    /**
     * 修改
     */
    @RequestMapping("/updateTeacher")
    @ResponseBody
    public void updateTeacher(Teacher teacher){
        teacherService.update(teacher);
    }
    /**
     * 增加
     */
    @RequestMapping("/insertTeacher")
    @ResponseBody
    public void insertTeacher(Teacher teacher){
        teacherService.save(teacher);
    }
}

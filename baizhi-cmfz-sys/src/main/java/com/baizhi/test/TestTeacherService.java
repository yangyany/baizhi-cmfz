package com.baizhi.test;

import com.baizhi.service.TeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

/**
 * Created by yanyan on 2017/6/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-basic.xml")
public class TestTeacherService {
    @Autowired
    private TeacherService teacherService;

    @Test
    public void test(){
        /*List<Teacher> teachers = teacherService.queryAll();*/
        Map map = teacherService.queryTeacherByPage(5, 1);
        System.out.println(map);
    }
}

package com.baizhi.test;

import com.baizhi.entity.Picture;
import com.baizhi.service.PictureService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yanyan on 2017/6/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-basic.xml")
public class TestPictureService {
    @Autowired
    private PictureService pictureService;
    @Test
    public void test(){
        Picture picture = pictureService.queryById("54e29042-6b8e-4d7b-8025-0b0ae997467a");
        System.out.println(picture);

    }

}

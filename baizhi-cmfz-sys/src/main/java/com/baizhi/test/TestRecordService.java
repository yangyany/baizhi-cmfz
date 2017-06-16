package com.baizhi.test;

import com.baizhi.entity.Record;
import com.baizhi.entity.User;
import com.baizhi.service.RecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * Created by yanyan on 2017/6/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-basic.xml")
public class TestRecordService {
    @Autowired
    private RecordService recordService;

    @Test
    public void testSelectAll() {
        Map map = recordService.queryRecordByPage(1, 1);
        System.out.println("**************"+map);
        List<Record> records = recordService.queryAll();
        System.out.println("================"+records);
        for (Record record : records) {
            User user = record.getUser();
            System.out.println(user);
        }

    }


}

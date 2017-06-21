package com.baizhi.test;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yanyan on 2017/6/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-basic.xml")
public class TestAdminService {
    @Autowired
    private AdminService adminService;
    @Test
    public void test(){
        //adminService.save(new Admin(null,"lisi","123456",null));
        Admin zhangsan = adminService.queryOne(new Admin(null, "zhangsan", "123456", null));
        System.out.println(zhangsan);
    }

}

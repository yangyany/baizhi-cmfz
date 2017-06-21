package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by yanyan on 2017/6/12.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
   @Resource
    private AdminService adminService;

    /**
     * 登录
     */
    @RequestMapping("/login")
    public String login(Admin admin){

        try {
            System.out.println(admin);
            Admin adminDB = adminService.queryOne(admin);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/back/main/main.jsp";

    }

}

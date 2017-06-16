package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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
    @ResponseBody
    public Map login(Admin admin){

        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            Admin adminDB = adminService.queryOne(admin);
            map.put("success","back/main/main");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("error",e.getMessage());
            return map;
        }

    }

}

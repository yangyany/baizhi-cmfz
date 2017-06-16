package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserServcie;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * Created by yanyan on 2017/6/13.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserServcie userServcie;

    /**
     * 注册
     */
    @RequestMapping("/saveUser")
    @ResponseBody
    public void saveUser(HttpServletRequest request, MultipartFile aaafile, User user) throws Exception {
        String str = UUID.randomUUID().toString();
        user.setId(str);
        String realPath = request.getSession().getServletContext().getRealPath("/back/image");
        String newFileName = UUID.randomUUID().toString() +
                new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
                + "."
                + FilenameUtils.getExtension(aaafile.getOriginalFilename());
        user.setPicpath(newFileName);
        try{
            aaafile.transferTo(new File(realPath,newFileName));
            userServcie.save(user);
        } catch (Exception e) {
            userServcie.delete(str);
            e.printStackTrace();
        }
    }
    /**
     * 查所有
     */
    /*@RequestMapping("/splitUser")
    @ResponseBody
    public Map splitUser(Integer pageNum,Integer pageSize){
        Page<User> users = userServcie.queryUserByPage(pageNum, pageSize);
        long total = users.getTotal();
        Map map = new HashMap();
        map.put("pageSize",users.getResult());
        map.put("total",total);
        return map;
    }*/
    /**
     * 分也查所有
     */
    @RequestMapping("/queryAllUser")
    @ResponseBody
    public Map queryAllUser(Integer page,Integer rows){
        Map map = userServcie.queryAllUserByPage(page, rows);
        return map;
    }
    /**
     * 登录
     */
   /* @RequestMapping("/login")
    @ResponseBody
    public Map login(User user){

        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            User userDB = userServcie.queryByUser(user);
            map.put("success","back/main/main");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("error",e.getMessage());
            return map;
        }
    }*/
    /**
     * 查一个
     */
    @RequestMapping("/queryOneUser")
    @ResponseBody
    public User queryOneUser(String id){
        User user = userServcie.queryById(id);
        return user;
    }
    /**
     * 删除
     */
    @RequestMapping("/deleteUser")
    @ResponseBody
    public void deleteUser(String id){
            userServcie.delete(id);
    }
    /**
     * 修改
     */
    @RequestMapping("/updateUser")
    @ResponseBody
    public void updateUser(User user){

            userServcie.update(user);

    }
}

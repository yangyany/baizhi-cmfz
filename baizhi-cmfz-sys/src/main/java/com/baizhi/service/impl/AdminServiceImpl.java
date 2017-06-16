package com.baizhi.service.impl;

import com.baizhi.dao.AdminDAO;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.util.MD5Utils;
import com.baizhi.util.SaltUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Created by yanyan on 2017/6/12.
 */
@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDAO adminDAO;

    public void save(Admin admin) {

        admin.setId(UUID.randomUUID().toString());
        String salt = SaltUtils.getSalt(6);
        admin.setSalt(salt);
        String md5Code = MD5Utils.getMd5Code(admin.getPassword() + salt);
        admin.setPassword(md5Code);
        adminDAO.insert(admin);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Admin queryOne(Admin admin) {
        Admin adminBD = adminDAO.selectOne(admin.getUsername());
        if(adminBD!=null){//管理员名称存在
            //验证密码
            if(MD5Utils.getMd5Code(admin.getPassword()+adminBD.getSalt()).equals(adminBD.getPassword())){
                //密码正确
                return adminBD;
            }
            throw new RuntimeException("密码错误！");
        }
        throw new RuntimeException("管理员名称错误！");
    }
}

package com.baizhi.service.impl;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import com.baizhi.service.UserServcie;
import com.baizhi.util.MD5Utils;
import com.baizhi.util.SaltUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by yanyan on 2017/6/12.
 */
@Service("userService")
@Transactional
public class UserServcieImpl implements UserServcie {
    @Autowired
    private UserDAO userDAO;
    public void save(User user) {
        user.setId(UUID.randomUUID().toString());
        String salt = SaltUtils.getSalt(6);
        String md5Code = MD5Utils.getMd5Code(user.getPassword() + salt);

        user.setPassword(md5Code);

        user.setSalt(salt);

        userDAO.insert(user);

    }


    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<User> queryAll() {

        return userDAO.selectAll();
    }

    public User queryById(String id) {

        return userDAO.selectById(id);
    }

    public User queryByUser(User user) {
        User userDB = userDAO.selectById(user.getId());
        String md5Code = MD5Utils.getMd5Code(user.getPassword() + userDB.getSalt());
        //用户用户名是否存在
        if(userDB!=null){
            if(md5Code.equals(userDB.getPassword())){
                return userDB;
            }
            throw new RuntimeException("密码错误！");
        }
        throw new RuntimeException("用户名错误!");
    }

    public void update(User user) {

        userDAO.update(user);
    }

    public void delete(String id) {
        userDAO.delete(id);
    }

   /* @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Page<User> queryUserByPage(Integer pageNum, Integer pageSize) {
        Page<User> page = PageHelper.startPage(pageNum, pageSize);
        userDAO.selectAll();
        return page;
    }*/
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Map queryAllUserByPage(Integer page, Integer rows) {
        List<User> users = userDAO.queryByPage((page - 1) * rows, rows);
        Integer total = userDAO.selectAll().size();

        Map map = new HashMap();
        map.put("rows",users);
        map.put("total",total);
        return map;
    }


}

package com.baizhi.service.impl;

import com.baizhi.dao.TeacherDAO;
import com.baizhi.entity.Teacher;
import com.baizhi.service.TeacherService;
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
@Service("teacherService")
@Transactional
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDAO teacherDAO;

    public void save(Teacher teacher) {
        teacher.setId(UUID.randomUUID().toString());
        teacherDAO.insert(teacher);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Teacher> queryAll() {

        return teacherDAO.selectAll();
    }

    public Teacher queryById(String id) {

        return teacherDAO.selectById(id);
    }

    public void update(Teacher teacher) {

        teacherDAO.update(teacher);
    }

    public void delete(String id) {
        teacherDAO.delete(id);

    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Map queryTeacherByPage(Integer page, Integer rows) {
        List<Teacher> teachers = teacherDAO.queryByPage((page-1)*rows,rows);
        Integer total = teacherDAO.selectAll().size();
        Map map = new HashMap();
        map.put("rows",teachers);
        map.put("total",total);
        return map;
    }
}

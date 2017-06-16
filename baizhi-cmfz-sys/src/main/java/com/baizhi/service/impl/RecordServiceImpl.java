package com.baizhi.service.impl;

import com.baizhi.dao.RecordDAO;
import com.baizhi.entity.Record;
import com.baizhi.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by yanyan on 2017/6/14.
 */
@Service("/recordService")
@Transactional
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordDAO recordDAO;
    public void save(Record record) {
        record.setId(UUID.randomUUID().toString());
        recordDAO.insert(record);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Record> queryAll() {

        return recordDAO.selectAll();
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Record queryById(String id) {
        return recordDAO.selectById(id);
    }

    public void update(Record record) {
        recordDAO.update(record);
    }

    public void delete(String id) {
        recordDAO.delete(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Map queryRecordByPage(Integer page, Integer rows) {
        List<Record> records = recordDAO.queryByPage((page - 1) * rows, rows);
        Integer total = recordDAO.selectAll().size();

        Map map = new HashMap();
        map.put("rows",records);
        map.put("total",total);
        return map;
    }
}

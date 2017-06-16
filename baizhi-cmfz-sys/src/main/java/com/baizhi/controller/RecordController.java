package com.baizhi.controller;

import com.baizhi.entity.Record;
import com.baizhi.service.RecordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by yanyan on 2017/6/15.
 */
@Controller
@RequestMapping("/record")
public class RecordController {
    @Resource
    private RecordService recordService;

    /**
     * 添加
     */
    @RequestMapping("/saveRd")
    public String saveRd(Record record){

        recordService.save(record);
        return "index";
    }

    /**
     * 查所有
     */
    @RequestMapping("/queryAllRecords")
    @ResponseBody
    public List<Record> queryAllRecords(){
        List<Record> records = recordService.queryAll();
        for (Record record : records) {
            System.out.println(record.getUser());
        }
        return records;
    }
    /**
     * 根据id查一个
     */
    @RequestMapping("/queryOneRecord")
    @ResponseBody
    public Record  queryOneRecord(String id){
        Record record = recordService.queryById(id);
        return record;
    }
    /**
     * 修改
     */
    @RequestMapping("/updateRecord")
    public void updateRecord(Record record){
        recordService.update(record);
    }
    /**
     * 删除
     */
    @RequestMapping("/deleteRecord")
    public void deleteRecord(String id){
        recordService.delete(id);
    }
    /**
     * 分页查询
     */
    @RequestMapping("/queryRecdByPage")
    public Map queryRecdByPage(Integer page, Integer rows){
        Map map = recordService.queryRecordByPage(page, rows);

        return map;
    }

}

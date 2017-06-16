package com.baizhi.controller;

import com.baizhi.entity.Province;
import com.baizhi.service.ProvinceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by yanyan on 2017/6/14.
 */
@Controller
@RequestMapping("/province")
public class ProvinceController {
    @Resource
    private ProvinceService provinceService;
    /**
     * 查一个
     */
    @RequestMapping("/queryOne")
    @ResponseBody
    public Province queryOne(String id){
        Province province = provinceService.queryById(id);
        return province;
    }
    /**
     * 查所有
     */
    @RequestMapping("/queryAllProvince")
    @ResponseBody
    public List<Province> queryAllProvince(){
        List<Province> provinces = provinceService.queryAll();
        return provinces;
    }
    /**
     * 修改
     */
    @RequestMapping("/updateProvince")
    public void updateProvince(Province province){

        provinceService.update(province);
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public void delete(String id){

        provinceService.delete(id);
    }

    /**
     * 添加
     */
    @RequestMapping("/saveProvince")
    public void saveProvince(Province province){
        provinceService.save(province);
    }

    /**
     * 分页查询
     */
    @RequestMapping("/queryProvinceByPage")
    @ResponseBody
    public Map queryProvinceByPage(Integer page, Integer rows){
        Map map = provinceService.queryProvinceByPage(page, rows);

        return map;
    }

  /*  @RequestMapping("/splitProvince")
    @ResponseBody
    public Map splitProvince(Integer pageNum,Integer pageSize){
        Page<Province> provinces = provinceService.queryProByPage(pageNum,pageSize);
        long total = provinces.getTotal();
        Map map = new HashMap();
        map.put("pageSize",provinces.getResult());
        map.put("total",total);
        return map;
    }*/
}

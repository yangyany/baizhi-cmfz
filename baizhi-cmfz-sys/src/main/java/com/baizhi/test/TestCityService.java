package com.baizhi.test;

import com.baizhi.service.CityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yanyan on 2017/6/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-basic.xml")
public class TestCityService {

    @Autowired
    private CityService cityService;
    @Test
    public void test(){
        /*Map map = provinceService.queryProvinceByPage(2,2);
        System.out.println(map);*/
      /*  List<Province> provinces = provinceService.queryAll();
        System.out.println(provinces);*/
    /*    Province province = provinceService.queryById("140000");
        System.out.println(province);*/

       /* Province province = new Province("","dasd");
        provinceService.save(province);*/
     /*   provinceService.delete("c6ad1c31-655f-47df-9881-44419eb00a6d");
        Province province1 = provinceService.queryById("c6ad1c31-655f-47df-9881-44419eb00a6d");
        System.out.println(province1);*/



    }

}

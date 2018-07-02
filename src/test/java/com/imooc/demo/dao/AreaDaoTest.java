package com.imooc.demo.dao;

import com.imooc.demo.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {
    @Autowired
    private AreaDao areaDao;
    @Test
    public void queryArea() {
        List<Area> areaList= areaDao.queryArea();
        assertEquals(2,areaList.size());
    }

    @Test
    public void queryAreaById() {
        Area area=areaDao.queryAreaById(1);
        assertEquals("东苑",area.getAreaName());
    }

    @Test
    public void insertArea() {
        Area area= new Area();
        area.setAreaName("南苑1");
        area.setPriority(1);
        int effectedNum=areaDao.insertArea(area);
        assertEquals(1,effectedNum);
    }

    @Test
    @Ignore
    public void updateArea() {
        Area area=new Area();
        area.setAreaId(3);
        area.setAreaName("西苑");
        area.setLastEditTime(new Date());
        int effectedNum=areaDao.updateArea(area);
        assertEquals(1,effectedNum);
    }

    @Test
    public void delArea() {
        int effectedNum= areaDao.delArea(4);
        assertEquals(1,effectedNum);
    }
}
package com.imooc.demo.service.impl;

import com.imooc.demo.dao.AreaDao;
import com.imooc.demo.entity.Area;
import com.imooc.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * create by maoxiangyu
 */
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;
    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

    @Override
    public Area getAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);
    }
    @Transactional
    @Override
    public boolean addArea(Area area) {
        if (area.getAreaName()!=null&& !"".equals(area.getAreaName())){
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try{
                int result=areaDao.insertArea(area);
                if (result>0){
                    return true;
                }else {
                    throw new RuntimeException("插入区域信息失败!");
                }
            }catch(Exception e){
                throw new RuntimeException("插入区域信息失败!"+e.getMessage());
            }
        }else {
            throw new RuntimeException("区域信息不能为空!");
        }
    }

    @Override
    @Transactional
    public boolean modifyArea(Area area) {
        if (area.getAreaId()!=null&& area.getAreaId()>0){
            //设置默认值
            area.setLastEditTime(new Date());
            try{
                //更新区域信息
                int result=areaDao.updateArea(area);
                if (result>0){
                    return true;
                }else {
                    throw new RuntimeException("更新区域信息失败!");
                }
            }catch(Exception e){
                throw new RuntimeException("更新区域信息失败!"+e.getMessage());
            }
        }else {
            throw new RuntimeException("区域信息不能为空!");
        }
    }

    @Override
    public boolean delArea(int areaId) {
        if (areaId > 0) {
            try {
                //删除区域信息
                int result = areaDao.delArea(areaId);
                if (result > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除区域信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除区域信息失败!" + e.getMessage());
            }
        } else {
            throw new RuntimeException("区域信息不能为空!");
        }
    }
}

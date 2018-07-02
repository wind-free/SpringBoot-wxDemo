package com.imooc.demo.service;

import com.imooc.demo.entity.Area;

import java.util.List;

public interface AreaService  {
    /**
     * 列出区域列表
     * @return arealist
     */
     List<Area> getAreaList();

    /**
     * 根据ID列出具体区域
     * @param areaId
     * @return
     */
     Area getAreaById(int areaId);

    /**
     * 插入区域信息
     * @param area
     * @return
     */
     boolean addArea(Area area);

    /**
     * 更新区域信息
     * @param area
     * @return
     */
       boolean modifyArea(Area area);

    /**
     * 根据Id删除区域信息
     * @param areaId
     * @return
     */
    boolean delArea(int areaId);
}

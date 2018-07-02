package com.imooc.demo.web;

import com.imooc.demo.entity.Area;
import com.imooc.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by maoxiangyu
 */
@RestController
@RequestMapping("/superadmin")
public class AreaController {
    @Autowired
    private AreaService areaService;
    @RequestMapping(value = "/listarea",method = RequestMethod.GET)
    private Map<String,Object>listarea(){
        Map<String,Object>modelMap=new HashMap<String, Object>();
        List<Area>areaList=areaService.getAreaList();
        modelMap.put("areaList",areaList);
        return modelMap;
    }
    @RequestMapping(value = "/getareabyid",method = RequestMethod.GET)
    private Map<String,Object>getAreaById(Integer areaId){
        Map<String,Object>modelMap=new HashMap<String, Object>();
        Area area=areaService.getAreaById(areaId);
        modelMap.put("area",area);
        return modelMap;
    }
    @RequestMapping(value = "/addarea",method = RequestMethod.POST)
    private Map<String,Object>addArea(@RequestBody Area area){
        Map<String,Object>modelMap=new HashMap<String, Object>();
        modelMap.put("success",areaService.addArea(area));
        return modelMap;
    }
    @RequestMapping(value = "/modifyarea",method = RequestMethod.POST)
    private Map<String,Object>modifyArea(@RequestBody Area area){
        Map<String,Object>modelMap=new HashMap<String, Object>();
        modelMap.put("success",areaService.modifyArea(area));
        return modelMap;
    }
    @RequestMapping(value = "/removearea",method = RequestMethod.GET)
    private Map<String,Object>removeArea(Integer areaId){
        Map<String,Object>modelMap=new HashMap<String, Object>();
        modelMap.put("success",areaService.delArea(areaId));
        return modelMap;
    }
}

package com.group.demo.service;

import com.github.pagehelper.PageInfo;
import com.group.demo.pojo.Ship;
import com.group.demo.pojo.UnloadList;

import java.util.List;

public interface ShipService {
    //新建船舶信息
    int add(Ship ship);
    //编辑船舶信息
    int update(Ship ship);
    //删除船舶信息
    int delete(int id);
    //查看船舶信息
    Ship getByID(int id);
    //获取船舶信息
    List<Ship> getAll();
    //查询船舶信息
    List<Ship> queryByKey(String key);

    PageInfo<Ship> getbypages(int pageNum, int pageSize);
}

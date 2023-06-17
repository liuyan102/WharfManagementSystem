package com.group.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.group.demo.mapper.ShipMapper;
import com.group.demo.pojo.Ship;
import com.group.demo.pojo.UnloadList;
import com.group.demo.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipServiceImpl implements ShipService {
    @Autowired
    ShipMapper shipMapper;

    @Override //新建船舶信息
    public int add(Ship ship){
        int add = shipMapper.add(ship);
        if(add > 0){ //新建成功
            return 1;
        }
        else { //新建失败
            return 0;
        }
    }

    @Override //编辑船舶信息
    public int update(Ship ship){
        int update = shipMapper.update(ship);
        if(update >= 0){ //编辑成功
            return 1;
        }
        else { //编辑失败
            return 0;
        }
    }

    @Override //删除船舶信息
    public int delete(int id){
        int delete = shipMapper.delete(id);
        if(delete >0){ //删除成功
            return 1;
        }
        else { //删除失败
            return 0;
        }
    }

    @Override //查看船舶信息
    public Ship getByID(int id){
        Ship ship = shipMapper.queryByID(id);
        if(ship != null){  //查看成功
            return ship;
        }
        else { //查看失败
            return null;
        }
    }

    @Override //获取船舶信息
    public List<Ship> getAll(){
        List<Ship> shipList = shipMapper.queryAll();
        if(shipList != null){ //获取成功
            return shipList;
        }
        else { //获取失败
            return null;
        }
    }

    @Override //查询船舶信息
    public List<Ship> queryByKey(String key){
        List<Ship> shipList = shipMapper.queryByKey(key);
        if(shipList != null){ //获取成功
            return  shipList;
        }
        else { //获取失败
            return null;
        }
    }

    @Override
    public PageInfo<Ship> getbypages(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Ship> shipList =  shipMapper.getbypages();
        return new PageInfo<>(shipList);
    }
}

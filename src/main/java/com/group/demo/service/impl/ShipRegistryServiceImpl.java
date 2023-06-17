package com.group.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.group.demo.mapper.ShipRegistryMapper;
import com.group.demo.pojo.Contract;
import com.group.demo.pojo.Ship;
import com.group.demo.pojo.ShipRegistry;
import com.group.demo.service.ShipRegistryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //@Service注解，将自动注册到Spring容器，不需要再在applicationContext.xml文件定义bean了
public class ShipRegistryServiceImpl implements ShipRegistryService{
    @Autowired //@Autowired 注释，它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。 通过 @Autowired的使用来消除 set ，get方法。

            ShipRegistryMapper shipRegistryMapper;

    @Override //重写
    public List<ShipRegistry> queryAll() {
        List<ShipRegistry> shipRegistryList=shipRegistryMapper.queryAll();
        if(shipRegistryList != null){ //获取成功
            return shipRegistryList;
        }
        else { //获取失败
            return null;
        }

    }
    @Override
    public int add(ShipRegistry shipRegistry)
    {
        int add=shipRegistryMapper.add(shipRegistry);
        if(add > 0){ //新建成功
            return 1;
        }
        else { //新建失败
            return 0;
        }
    }
    @Override
    public ShipRegistry queryById(int ShipregID)
    {
        ShipRegistry shipRegistry= shipRegistryMapper.queryById(ShipregID);
        if(shipRegistry != null){ //查看成功
            return shipRegistry;
        }
        else { //查看失败
            return null;
        }
    }
    @Override
    public List<ShipRegistry> queryByKey(String key){
        List<ShipRegistry> shipRegistryList = shipRegistryMapper.queryByKey(key);
        if(shipRegistryList != null){ //查看成功
            return shipRegistryList;
        }
        else { //查看失败
            return null;
        }
    }
    @Override
    public int delete(int ShipregID)
    {

        int delete=shipRegistryMapper.delete(ShipregID);
        if(delete > 0){ //删除成功
            return 1;
        }
        else { //删除失败
            return 0;
        }
    }
    @Override
    public int update(ShipRegistry shipRegistry)
    {
        int update=shipRegistryMapper.update(shipRegistry);
        if(update >= 0){ //编辑成功
            return 1;
        }
        else { //编辑失败
            return 0;
        }
    }
    @Override
    public PageInfo<ShipRegistry> getbypages(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ShipRegistry> shipRegistryList =  shipRegistryMapper.getbypages();
        return new PageInfo<>(shipRegistryList);
    }
}

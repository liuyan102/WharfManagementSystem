package com.group.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.group.demo.mapper.InformMapper;
import com.group.demo.pojo.Contract;
import com.group.demo.pojo.Inform;;
import com.group.demo.pojo.Ship;
import com.group.demo.service.InformService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //@Service注解，将自动注册到Spring容器，不需要再在applicationContext.xml文件定义bean了
public class InformServiceImpl implements InformService{
    @Autowired //@Autowired 注释，它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。 通过 @Autowired的使用来消除 set ，get方法。

            InformMapper informMapper;

    @Override //重写
    public List<Inform> queryAll() {
        List<Inform>informList=informMapper.queryAll();
        if(informList != null){ //获取成功
            return informList;
        }
        else { //获取失败
            return null;
        }
    }
    @Override
    public int add(Inform inform)
    {
        int add=informMapper.add(inform);
        if(add > 0){ //新建成功
            return 1;
        }
        else { //新建失败
            return 0;
        }
    }
    @Override
    public Inform queryById(int InformID)
    {
        Inform inform = informMapper.queryById(InformID);
        if(inform != null){ //查看成功
            return inform;
        }
        else { //查看失败
            return null;
        }
    }
    @Override
    public List<Inform> queryByKey(String key){
        List<Inform> informList = informMapper.queryByKey(key);
        if(informList != null){ //查看成功
            return informList;
        }
        else { //查看失败
            return null;
        }
    }
    @Override
    public int delete(int InformID)
    {
        int delete=informMapper.delete(InformID);
        if(delete > 0){ //删除成功
            return 1;
        }
        else { //删除失败
            return 0;
        }
    }
    @Override
    public  int update(Inform inform){
        int update=informMapper.update(inform);
        if(update >= 0){ //编辑成功
            return 1;
        }
        else { //编辑失败
            return 0;
        }
    }
    @Override
    public PageInfo<Inform> getbypages(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Inform> informList =  informMapper.getbypages();
        return new PageInfo<>(informList);
    }
}

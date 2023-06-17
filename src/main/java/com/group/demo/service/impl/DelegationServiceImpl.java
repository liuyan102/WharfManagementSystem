package com.group.demo.service.impl;

import com.group.demo.mapper.DelegationMapper;
import com.group.demo.pojo.Delegation;
import com.group.demo.service.DelegationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //@Service注解，将自动注册到Spring容器，不需要再在applicationContext.xml文件定义bean了
public class DelegationServiceImpl implements DelegationService {
    @Autowired //@Autowired 注释，它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。 通过 @Autowired的使用来消除 set ，get方法。

            DelegationMapper delegationMapper;

    @Override //重写
    public List<Delegation> queryAll() {
        List<Delegation> delegationList=delegationMapper.queryAll();
        if(delegationList != null){ //获取成功
            return delegationList;
        }
        else { //获取失败
            return null;
        }

    }
    @Override
    public int add(Delegation delegation)
    {
        int add=delegationMapper.add(delegation);
        if(add > 0){ //新建成功
            return 1;
        }
        else { //新建失败
            return 0;
        }
    }
    @Override
    public Delegation queryById(int DelegationID)
    {
        return delegationMapper.queryById(DelegationID);
    }
    @Override
    public int delete(int DelegationID)
    {
        return delegationMapper.delete(DelegationID);
    }
    @Override
    public int update(Delegation delegation){
        return delegationMapper.update(delegation);
    }
}

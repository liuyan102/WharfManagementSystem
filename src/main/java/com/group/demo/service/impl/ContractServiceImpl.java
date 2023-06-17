package com.group.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.group.demo.mapper.ContractMapper;
import com.group.demo.pojo.Contract;
import com.group.demo.pojo.Ship;
import com.group.demo.pojo.UnloadList;
import com.group.demo.service.ContractService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //@Service注解，将自动注册到Spring容器，不需要再在applicationContext.xml文件定义bean了
public class ContractServiceImpl implements ContractService {
    @Autowired //@Autowired 注释，它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。 通过 @Autowired的使用来消除 set ，get方法。

            ContractMapper contractMapper;

    @Override //重写
    public List<Contract> queryAll() {
        List<Contract> contractList=contractMapper.queryAll();
        if(contractList != null){ //获取成功
            return contractList;
        }
        else { //获取失败
            return null;
        }

    }
    @Override
    public int add(Contract contract)
    {
        int add=contractMapper.add(contract);
        if(add > 0){ //新建成功
            return 1;
        }
        else { //新建失败
            return 0;
        }
    }
    @Override
    public Contract queryById(int ContractID)
    {
        Contract contract = contractMapper.queryById(ContractID);
        if(contract != null){ //查看成功
            return contract;
        }
        else { //查看失败
            return null;
        }
    }
    @Override
    public List<Contract> queryByKey(String key){
        List<Contract> contractList = contractMapper.queryByKey(key);
        if(contractList != null){ //查看成功
            return contractList;
        }
        else { //查看失败
            return null;
        }
    }
    @Override
    public int delete(int ContractID)
    {
        int delete=contractMapper.delete(ContractID);
        if(delete > 0){ //删除成功
            return 1;
        }
        else { //删除失败
            return 0;
        }

    }
    @Override
    public  int update(Contract contract){
        int update=contractMapper.update(contract);
        if(update >= 0){ //编辑成功
            return 1;
        }
        else { //编辑失败
            return 0;
        }
    }
    @Override
    public PageInfo<Contract> getbypages(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Contract> contractList =  contractMapper.getbypages();
        return new PageInfo<>(contractList);
    }
}

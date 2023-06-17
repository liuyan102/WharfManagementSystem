package com.group.demo.mapper;

import com.group.demo.pojo.Contract; //需要引用pojo文件中对应的方法类
import com.group.demo.pojo.Ship;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ContractMapper {   //数据库方法接口 增删改查等
    public List<Contract> queryAll();
    public int add(Contract contract);
    public Contract queryById(int ContractID);
    public List<Contract> queryByKey(String key);
    public int delete(int ContractID);
    public int update(Contract contract);
    List<Contract> getbypages();
}
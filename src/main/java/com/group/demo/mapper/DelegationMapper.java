package com.group.demo.mapper;

import com.group.demo.pojo.Delegation; //需要引用pojo文件中对应的方法类
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DelegationMapper {   //数据库方法接口 增删改查等
    public List<Delegation> queryAll();
    public int add(Delegation delegation);
    public Delegation queryById(int DelegationID);
    public int delete(int DelegationID);
    public int update(Delegation delegation);
}

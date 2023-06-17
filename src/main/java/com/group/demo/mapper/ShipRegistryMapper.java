package com.group.demo.mapper;

import com.group.demo.pojo.Inform;
import com.group.demo.pojo.Ship;
import com.group.demo.pojo.ShipRegistry; //需要引用pojo文件中对应的方法类
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ShipRegistryMapper {   //数据库方法接口 增删改查等
    public List<ShipRegistry> queryAll();
    public int add(ShipRegistry shipRegistry);
    public ShipRegistry queryById(int ShipregID);
    public List<ShipRegistry> queryByKey(String key);
    public int delete(int ShipregID);
    public int update(ShipRegistry shipRegistry);
    List<ShipRegistry> getbypages();
}
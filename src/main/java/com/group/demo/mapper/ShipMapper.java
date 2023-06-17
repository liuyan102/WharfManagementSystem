package com.group.demo.mapper;

import com.group.demo.pojo.Ship;
import com.group.demo.pojo.UnloadList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ShipMapper {
    int add(Ship ship);
    Ship queryByID(int id);
    List<Ship> queryAll();
    List<Ship> queryByKey(String key);
    int update(Ship ship);
    int delete(int id);
    List<Ship> getbypages();
}

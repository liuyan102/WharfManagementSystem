package com.group.demo.mapper;

import com.group.demo.pojo.Contract;
import com.group.demo.pojo.Inform; //需要引用pojo文件中对应的方法类
import com.group.demo.pojo.Ship;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface InformMapper {   //数据库方法接口 增删改查等
    public List<Inform> queryAll();
    public int add(Inform inform);
    public Inform queryById(int InformID);
    public List<Inform> queryByKey(String key);
    public int delete(int InformID);
    public  int update(Inform inform);
    List<Inform> getbypages();
}
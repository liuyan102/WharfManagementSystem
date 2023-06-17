package com.group.demo.mapper;

import com.group.demo.pojo.UserLogin; //需要引用pojo文件中对应的方法类
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserLoginMapper {   //数据库方法接口 增删改查等
    public List<UserLogin> queryAll();
    public int add(UserLogin userLogin);
    public UserLogin queryByName(String username);
}

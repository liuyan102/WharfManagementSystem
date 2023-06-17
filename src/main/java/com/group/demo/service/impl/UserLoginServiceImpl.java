package com.group.demo.service.impl;

import com.group.demo.mapper.UserLoginMapper;
import com.group.demo.pojo.UserLogin;
import com.group.demo.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //@Service注解，将自动注册到Spring容器，不需要再在applicationContext.xml文件定义bean了
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired //@Autowired 注释，它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。 通过 @Autowired的使用来消除 set ，get方法。
    UserLoginMapper userLoginMapper;

    @Override //重写
    public List<UserLogin> queryAll() {
        return userLoginMapper.queryAll();
    }

    @Override
    public int add(UserLogin userLogin) {
        return userLoginMapper.add(userLogin);
    }

    @Override
    public UserLogin queryByName(String username) {
        return userLoginMapper.queryByName(username);
    }

}

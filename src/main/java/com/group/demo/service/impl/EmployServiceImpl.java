package com.group.demo.service.impl;

import com.group.demo.mapper.EmployMapper;
import com.group.demo.pojo.Employ;
import com.group.demo.service.EmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.CredentialNotFoundException;

@Service
public class EmployServiceImpl implements EmployService {
    @Autowired
    EmployMapper employMapper;

    @Override//员工注册
    public int register(Employ employ){
        String username = employ.getUsername();
        Employ employ1 = employMapper.queryByUsername(username);
        if(employ1 != null){ //用户名已存在
            return -1;
        }
        int add = employMapper.add(employ);
        if(add > 0){ //注册成功
            return 1;
        }
        else { //注册失败
            return 0;
        }
    }

    @Override
    public Employ login(String username,String password){
        Employ employ = employMapper.queryByUsername(username);
        if(employ == null){ //用户名错误
            return null;
        }
        String password1 = employ.getPassword();
        if(password1.equals(password)){
            return  employ; //登陆成功
        }
        else {
            return null; //登录失败
        }
    }

    @Override //修改密码
    public int updatePassword(Employ employ){
        int update = employMapper.updatePassword(employ);
        if(update >= 0){ //成功
            return 1;
        }
        else { //失败
            return 0;
        }
    }

    @Override //修改个人信息
    public  int updateEmploy(Employ employ){
        int update = employMapper.updateEmploy(employ);
        if(update >= 0){ //成功
            return 1;
        }
        else { //失败
            return 0;
        }
    }
}

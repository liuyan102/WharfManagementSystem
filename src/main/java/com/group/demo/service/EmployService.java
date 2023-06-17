package com.group.demo.service;

import com.group.demo.pojo.Employ;


public interface EmployService {
    //员工注册
    int register(Employ employ);
    //员工登录
    Employ login(String username, String password);
    //修改密码
    int updatePassword(Employ employ);
    //修改个人信息
    int updateEmploy(Employ employ);
}

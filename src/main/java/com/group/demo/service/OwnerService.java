package com.group.demo.service;

import com.group.demo.pojo.Owner;

public interface OwnerService {
    //货主注册
    int register(Owner owner);
    //货主登录
    Owner login(String username, String password);
    //修改密码
    int updatePassword(Owner owner);
    //修改个人信息
    int updateOwner(Owner owner);
}

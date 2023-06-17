package com.group.demo.service.impl;

import com.group.demo.mapper.OwnerMapper;
import com.group.demo.pojo.Owner;
import com.group.demo.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service//@Service注解，将自动注册到Spring容器，不需要再在applicationContext.xml文件定义bean了
public class OwnerServiceImpl implements OwnerService {
    @Autowired//@Autowired 注释，它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。 通过 @Autowired的使用来消除 set ，get方法。
    OwnerMapper ownerMapper;

    @Override //货主注册
    public int register(Owner owner){
        String username = owner.getUsername();
        Owner owner1 = ownerMapper.queryByUsername(username);
        if (owner1 != null){ //用户名已存在
            return -1;
        }
        int add = ownerMapper.add(owner);
        if (add > 0){ //注册成功
            return 1;
        }
        else { //注册失败
            return 0;
        }
    }

    @Override //货主登录
    public Owner login(String username,String password){
        Owner owner = ownerMapper.queryByUsername(username);
        if (owner == null){ //用户名错误
             return null;
        }
        String password1=owner.getPassword();
        if (password1.equals(password)){ //登录成功
            return owner;
        }
        else { //密码错误
            return null;
        }
    }

    @Override //修改密码
    public int updatePassword(Owner owner){
        int update = ownerMapper.updatePassword(owner);
        if (update >= 0){ //修改密码成功
            return 1;
        }
        else { //修改密码失败
            return 0;
        }
    }

    @Override //修改个人信息
    public int updateOwner(Owner owner){
        int update = ownerMapper.updateOwner(owner);
        if (update >= 0){ //修改个人信息成功
            return 1;
        }
        else { //修改失败
            return 0;
        }
    }

}

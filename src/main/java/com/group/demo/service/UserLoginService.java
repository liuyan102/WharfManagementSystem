package com.group.demo.service;

import com.group.demo.pojo.UserLogin;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserLoginService {

    public List<UserLogin> queryAll();
    public int add(UserLogin userLogin);
    public UserLogin queryByName(String username);
}
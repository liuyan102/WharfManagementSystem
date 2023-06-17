package com.group.demo.controller;

import com.group.demo.pojo.UserLogin;
import com.group.demo.service.UserLoginService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserLoginController {
    @Autowired
    private UserLoginService userLoginService;

    @PostMapping( "/login")
    @ResponseBody
    //user是一个bean类
    public UserLogin login(@RequestBody UserLogin requestUser) {
        System.out.println(requestUser);
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = "requestUserwang";
        return requestUser;
    }
    @PostMapping( "/formpost")
    @ResponseBody
    public int formpost(@RequestParam Map<String,Object> reqMap, Model model) {
        String qingdan=reqMap.get("qd").toString();
        String phone=reqMap.get("dh").toString();
        System.out.println(qingdan+":"+phone);
        return 200;
    }

    @RequestMapping("/tologin")
    public String toLogin(String username,String password,String select){
        return "login";
    }

    @RequestMapping("/loginSuccess")
    public String loginSuccess(UserLogin userLogin){
        UserLogin userLogin1 = userLoginService.queryByName(("1"));
        if (userLogin1 != null){
            System.out.println(userLogin1);
            return "success";
        }else{
            return "login";
        }
    }

    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("/toRegisterSuccess")
    public String toRegisterSuccess(Model model, UserLogin userLogin){
        int add = userLoginService.add(userLogin);
        model.addAttribute("data","注册成功，请登录");
        return "login";
    }

}

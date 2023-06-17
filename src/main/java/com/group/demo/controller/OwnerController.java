package com.group.demo.controller;

import com.group.demo.enums.ResultCode;
import com.group.demo.pojo.Owner;
import com.group.demo.result.ResultReturn;
import com.group.demo.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
@CrossOrigin//跨域
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @PostMapping("/ownerRegister") //用户注册判断
    @ResponseBody
    public ResultReturn register(@RequestParam Map<String,Object> reqMap, Model model){
        Owner owner=new Owner();
        owner.setOwnerName(reqMap.get("ownerName").toString());
        owner.setUsername(reqMap.get("username").toString());
        owner.setPassword(reqMap.get("password").toString());
        owner.setOwnerPhone(reqMap.get("ownerPhone").toString());
        owner.setOwnerMail(reqMap.get("ownerMail").toString());
        System.out.println(owner);
        int register = ownerService.register(owner);
        if(register == -1){ //用户名已存在
            return ResultReturn.resultReturn(ResultCode.USERNAME_ALREADY_EXISTS.getCode(),
                    ResultCode.USERNAME_ALREADY_EXISTS.getMessage(),owner);
        }
        else if(register == 0){ //注册失败
            return ResultReturn.resultReturn(ResultCode.REGISTER_FAILURE.getCode(),
                    ResultCode.REGISTER_FAILURE.getMessage(),owner);
        }
        else { //注册成功
            return ResultReturn.resultReturn(ResultCode.REGISTER_SUCCESS.getCode(),
                    ResultCode.REGISTER_SUCCESS.getMessage(),owner);
        }
    }

    @PostMapping("/ownerLogin") //登录判断
    @ResponseBody
    public ResultReturn login(@RequestBody Owner owner) {
        System.out.println(owner);
        Owner owner1 = ownerService.login(owner.getUsername(),owner.getPassword());
        if(owner1 == null){ //用户名或密码错误
            return  ResultReturn.resultReturn(ResultCode.USERNAME_OR_PASSWORD_ERROR.getCode(),
                    ResultCode.USERNAME_OR_PASSWORD_ERROR.getMessage(),owner);
        }else { //登录成功
            return ResultReturn.resultReturn(ResultCode.LOGIN_SUCCESS.getCode(),
                    ResultCode.LOGIN_SUCCESS.getMessage(),owner1);
        }
    }

    @PostMapping("/updateOwnerPassword") //修改密码判断
    @ResponseBody
    public ResultReturn updatePassword(@RequestBody Owner owner,String oldPassword,String newPassword1,String newPassword2) {
        if(!owner.getPassword().equals(oldPassword) ){
            return ResultReturn.resultReturn(ResultCode.OLD_PASSWORD_ERROR.getCode(),
                    ResultCode.OLD_PASSWORD_ERROR.getMessage(),owner);
        }
        if(!newPassword1.equals(newPassword2)){ //
            return ResultReturn.resultReturn(ResultCode.NEW_PASSWORD_ERROR.getCode(),
                    ResultCode.NEW_PASSWORD_ERROR.getMessage(),owner);
        }
        owner.setPassword(newPassword1);
        int update = ownerService.updatePassword(owner);
        if (update == 1){
            return ResultReturn.resultReturn(ResultCode.UPDATE_SUCCESS.getCode(),
                    ResultCode.UPDATE_SUCCESS.getMessage(),owner);
        }
        else{
            return ResultReturn.resultReturn(ResultCode.UPDATE_FAILURE.getCode(),
                    ResultCode.UPDATE_FAILURE.getMessage(),owner);
        }
    }

    @PostMapping("/updateOwner") //修改个人信息判断
    @ResponseBody
    public ResultReturn updateOwner(@RequestBody Owner owner){
        int update = ownerService.updateOwner(owner);
        if(update == 1){
            return ResultReturn.resultReturn(ResultCode.UPDATE_SUCCESS.getCode(),
                    ResultCode.UPDATE_SUCCESS.getMessage(),owner);
        }else {
            return ResultReturn.resultReturn(ResultCode.UPDATE_FAILURE.getCode(),
                    ResultCode.UPDATE_FAILURE.getMessage(),owner);
        }
    }
}

package com.group.demo.controller;

import com.group.demo.enums.ResultCode;
import com.group.demo.pojo.Employ;
import com.group.demo.result.ResultReturn;
import com.group.demo.service.EmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class EmployController {
    @Autowired
    private EmployService employService;

    @PostMapping("/employRegister")//员工注册判断
    @ResponseBody
    public ResultReturn register(@RequestParam Map<String,Object> reqMap, Model model){
        Employ employ =new Employ();
        employ.setUsername(reqMap.get("username").toString());
        employ.setPassword(reqMap.get("password").toString());
        employ.setEmployName(reqMap.get("employName").toString());
        employ.setEmploySex(reqMap.get("employSex").toString());
        employ.setEmployAge(Integer.parseInt(reqMap.get("employAge").toString()));
        employ.setEmployBirth(reqMap.get("employBirth").toString());
        employ.setEmployPhone(reqMap.get("employPhone").toString());
        employ.setEmployMail(reqMap.get("employMail").toString());
        employ.setEmployPosition(reqMap.get("employPosition").toString());
        int register = employService.register(employ);
        if(register == -1){ //用户名已存在
            return ResultReturn.resultReturn(ResultCode.USERNAME_ALREADY_EXISTS.getCode(),
                    ResultCode.USERNAME_ALREADY_EXISTS.getMessage(),employ);
        }
        else if(register == 0){ //注册失败
            return ResultReturn.resultReturn(ResultCode.REGISTER_FAILURE.getCode(),
                    ResultCode.REGISTER_FAILURE.getMessage(),employ);
        }
        else { //注册成功
            return ResultReturn.resultReturn(ResultCode.REGISTER_SUCCESS.getCode(),
                    ResultCode.REGISTER_SUCCESS.getMessage(),employ);
        }
    }




    @PostMapping("/employLogin")
    @ResponseBody
    public ResultReturn login(@RequestBody Employ employ){
        Employ employ1 = employService.login(employ.getUsername(),employ.getPassword());
        if(employ1 == null){
            return  ResultReturn.resultReturn(ResultCode.USERNAME_OR_PASSWORD_ERROR.getCode(),
                    ResultCode.USERNAME_OR_PASSWORD_ERROR.getMessage(),employ);
        }else {
            return ResultReturn.resultReturn(ResultCode.LOGIN_SUCCESS.getCode(),
                    ResultCode.LOGIN_SUCCESS.getMessage(),employ1);
        }
    }

    @PostMapping("updateEmployPassword") //修改密码
    @ResponseBody
    public ResultReturn updatePassword(@RequestBody Employ employ,String oldPassword, String newPassword1, String newPassword2){
        if(!employ.getPassword().equals(oldPassword)){
            return ResultReturn.resultReturn(ResultCode.OLD_PASSWORD_ERROR.getCode(),
                    ResultCode.OLD_PASSWORD_ERROR.getMessage(),employ);
        }
        if(!newPassword1.equals(newPassword2)){
            return ResultReturn.resultReturn(ResultCode.NEW_PASSWORD_ERROR.getCode(),
                    ResultCode.NEW_PASSWORD_ERROR.getMessage(),employ);
        }
        employ.setPassword(newPassword1);
        int update = employService.updatePassword(employ);
        if (update == 1){
            return ResultReturn.resultReturn(ResultCode.UPDATE_SUCCESS.getCode(),
                    ResultCode.UPDATE_SUCCESS.getMessage(),employ);
        }
        else{
            return ResultReturn.resultReturn(ResultCode.UPDATE_FAILURE.getCode(),
                    ResultCode.UPDATE_FAILURE.getMessage(),employ);
        }
    }

    @PostMapping("/updateEmploy") //修改员工信息判断
    @ResponseBody
    public ResultReturn updateEmploy(@RequestBody Employ employ){
        int update = employService.updateEmploy(employ);
        if(update == 1){
            return ResultReturn.resultReturn(ResultCode.UPDATE_SUCCESS.getCode(),
                    ResultCode.UPDATE_SUCCESS.getMessage(),employ);
        }
        else {
            return ResultReturn.resultReturn(ResultCode.UPDATE_FAILURE.getCode(),
                    ResultCode.UPDATE_FAILURE.getMessage(), employ);
        }
    }
}

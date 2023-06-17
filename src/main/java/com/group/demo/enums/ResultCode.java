package com.group.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*
    结果枚举类
 */
@Getter
@AllArgsConstructor
public enum ResultCode {
    //以下响应结果 在ResultReturn中已经定义带数据对象和不带数据对象的静态函数 可以直接调用
    SUCCESS(100,"成功"),
    FAILURE(200,"失败"),
    UNKNOWN_ERROR(300,"未知错误"),
    PARAM_ERROR(400,"参数错误"),
    NULL_POINT(500,"空指针异常"),
    HTTP_CLIENT_ERROR(600,"客户端连接异常"),

    //以下响应结果 没有定义函数 使用时需要调用resultReturn函数 待补充
    LOGIN_SUCCESS(101,"登陆成功"),
    REGISTER_SUCCESS(102,"注册成功"),
    ADD_SUCCESS(103,"添加成功"),
    UPDATE_SUCCESS(104,"编辑成功"),
    DELETE_SUCCESS(105,"删除成功"),
    GET_SUCCESS(106,"获取成功"),
    QUERY_SUCCESS(107,"查询成功"),

    LOGIN_FAILURE(201,"登陆失败"),
    REGISTER_FAILURE(202,"注册失败"),
    ADD_FAILURE(203,"添加失败"),
    UPDATE_FAILURE(204,"编辑失败"),
    DELETE_FAILURE(205,"删除失败"),
    GET_FAILURE(206,"获取失败"),
    QUERY_FAILURE(207,"查询失败"),

    USERNAME_OR_PASSWORD_ERROR(401,"用户名或密码错误"),
    USERNAME_ALREADY_EXISTS(403,"用户名已存在"),
    OLD_PASSWORD_ERROR(404,"原密码错误"),
    NEW_PASSWORD_ERROR(405,"两次密码输入不一致"),;



    //状态码
    private Integer code;
    //提示信息
    private String message;

}

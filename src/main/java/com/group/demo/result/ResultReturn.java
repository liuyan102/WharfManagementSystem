package com.group.demo.result;

import com.group.demo.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/*
    响应结果统一格式实现类

    Serializable接口为序列化的过程，就是一个“freeze”的过程：
    它将一个对象freeze（冷冻）住，然后进行存储，等到再次需要的时候，再将这个对象de-freeze就可以立即使用。
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultReturn implements Serializable {
    private Integer code;
    private String message;
    private Object data;

    /*
      没有数据返回 人为指定状态码和提示信息
   */
    public static ResultReturn resultReturn(Integer code, String message){
        ResultReturn result = new ResultReturn();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    /*
        有数据返回 人为指定状态码和提示信息
     */
    public static ResultReturn resultReturn(Integer code,String message,Object data){
        ResultReturn result = new ResultReturn();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    /*a
     */
    public static ResultReturn success(){
        ResultReturn result = new ResultReturn();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(ResultCode.SUCCESS.getMessage());
        return result;
    }

    /*
        有数据返回 通用返回成功
        @param data
     */
    public static ResultReturn success(Object data){
        ResultReturn result = new ResultReturn();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(ResultCode.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    /*
       没有数据返回 通用返回失败
    */
    public static ResultReturn failure(){
        ResultReturn result = new ResultReturn();
        result.setCode(ResultCode.FAILURE.getCode());
        result.setMessage(ResultCode.FAILURE.getMessage());
        return result;
    }

    /*
        有数据返回 通用返回失败
        @param data
     */
    public static ResultReturn failure(Object data){
        ResultReturn result = new ResultReturn();
        result.setCode(ResultCode.FAILURE.getCode());
        result.setMessage(ResultCode.FAILURE.getMessage());
        result.setData(data);
        return result;
    }

    /*
        没有数据返回 发生未知错误
     */
    public static ResultReturn unknownError(){
        ResultReturn result = new ResultReturn();
        result.setCode(ResultCode.UNKNOWN_ERROR.getCode());
        result.setMessage(ResultCode.UNKNOWN_ERROR.getMessage());
        return result;
    }

    /*
       有数据返回 发生未知错误
       @param data
    */
    public static ResultReturn unknownError(Object date){
        ResultReturn result = new ResultReturn();
        result.setCode(ResultCode.UNKNOWN_ERROR.getCode());
        result.setMessage(ResultCode.UNKNOWN_ERROR.getMessage());
        result.setData(date);
        return result;
    }

    /*
        没有数据返回 发生参数错误
     */
    public static ResultReturn paramError(){
        ResultReturn result = new ResultReturn();
        result.setCode(ResultCode.PARAM_ERROR.getCode());
        result.setMessage(ResultCode.PARAM_ERROR.getMessage());
        return result;
    }

    /*
        有数据返回 发生参数错误
        @param data
     */
    public static ResultReturn paramError(Object date){
        ResultReturn result = new ResultReturn();
        result.setCode(ResultCode.PARAM_ERROR.getCode());
        result.setMessage(ResultCode.PARAM_ERROR.getMessage());
        result.setData(date);
        return result;
    }

    /*
        没有数据返回 发生空指针异常
     */
    public static ResultReturn nullPointError(){
        ResultReturn result = new ResultReturn();
        result.setCode(ResultCode.NULL_POINT.getCode());
        result.setMessage(ResultCode.NULL_POINT.getMessage());
        return result;
    }

    /*
        有数据返回 发生空指针异常
        @param data
     */
    public static ResultReturn nullPointError(Object date){
        ResultReturn result = new ResultReturn();
        result.setCode(ResultCode.NULL_POINT.getCode());
        result.setMessage(ResultCode.NULL_POINT.getMessage());
        result.setData(date);
        return result;
    }

    /*
        没有数据返回 发生客户端连接异常
     */
    public static ResultReturn httpClientError(){
        ResultReturn result = new ResultReturn();
        result.setCode(ResultCode.HTTP_CLIENT_ERROR.getCode());
        result.setMessage(ResultCode.HTTP_CLIENT_ERROR.getMessage());
        return result;
    }

    /*
        有数据返回 发生客户端连接异常
        @param data
     */
    public static ResultReturn httpClientError(Object date){
        ResultReturn result = new ResultReturn();
        result.setCode(ResultCode.HTTP_CLIENT_ERROR.getCode());
        result.setMessage(ResultCode.HTTP_CLIENT_ERROR.getMessage());
        result.setData(date);
        return result;
    }
}

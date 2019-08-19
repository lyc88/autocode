package com.example.demo.bean;


import lombok.Data;


/**
 * @author lyc
 * @date 2019/8/13.
 */
@Data
public class CommonResultResponse<T>{

    public static <T> CommonResult ok(T data){
       return new CommonResult<T>(200,data,"success");
    }

    public static <T> CommonResult ok(T data,String msg){
        return new CommonResult<T>(200,data,msg);
    }

    public  static <T> CommonResult fail(T data){
        return new CommonResult<T>(500,data,"error");
    }

    public  static <T> CommonResult fail(T data,String msg){
        return new CommonResult<T>(500,data,msg);
    }
}
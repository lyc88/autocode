package com.example.demo.bean;


import lombok.Data;


/**
 * @author lyc
 * @date 2019/8/13.
 */
@Data
public class CommonResultResponse<T>{

    public  CommonResult ok(T data){
       return new CommonResult<T>(200,data,"success");
    }

    public  CommonResult fail(T data){
        return new CommonResult<T>(500,data,"error");
    }
}
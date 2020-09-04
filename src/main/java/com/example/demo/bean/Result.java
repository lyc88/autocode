package com.example.demo.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    /**
     * 状态码 0 正常 其他错误
     */
    @ApiModelProperty(name = "code",value = "状态码 0 正常 其他错误")
    private int code;

    /**
     * 提示信息
     */
    @ApiModelProperty(name = "msg",value = "提示信息",notes = "提示信息")
    private String msg;

    /**
     * 数据
     */
    @ApiModelProperty(name = "data",value = "数据",notes = "数据")
    private T data;

    public static <T> Result<T> ok(){
        return new Result(0,"success",null);
    }
    public static <T> Result<T> ok(T data){
        return new Result(0,"success",data);
    }

    public static <T> Result<T> ok(T data,String msg){
        return new Result(0,msg,data);
    }

    public  static <T> Result fail(){
        return new Result(500,"error",null);
    }

    public  static <T> Result fail(T data){
        return new Result(500,"error",data);
    }

    public  static <T> Result fail(T data,String msg){
        return new Result(500,msg,data);
    }
    public  static <T> Result fail(T data,String msg,int code){
        return new Result(code,msg,data);
    }



}

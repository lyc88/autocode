package com.example.demo.bean;


import lombok.Data;

/**
 * 值对象:VO(Value object)
 * 1)封装控制层相关方法返回的数据
 * 2)统一服务端相关方法返回的数据格式
 *
 * @author 53166
 */
@Data
public class ResultVO<T> {
    public static final String SUCCESS = "200";
    public static final String ERROR = "500";
    //状态
    private String state;
    //状态信息
    private String message;
    //具体数据
    private T data;

    private String code;


    public ResultVO() {
        state = SUCCESS;
        code = SUCCESS;
        message="成功";
    }

    public ResultVO(T data) {
        this();
        this.data = data;
    }

    public ResultVO(T data, String message) {
        this.state = SUCCESS;
        this.code = SUCCESS;
        this.message=message;
        this.data = data;
    }

    public ResultVO(Throwable exp) {

        state = ERROR;
        this.message = exp.getMessage();

        code = "500";


    }

    public ResultVO(String msg, T data, String code) {
        state = ERROR;
        this.message = msg;
        code = code;
        data = data;
    }


    public static <T> ResultVO<T> ok(){
        return new ResultVO("成功",null,SUCCESS);
    }
    public static <T> ResultVO<T> ok(T data){
        return new ResultVO("成功",data,SUCCESS);
    }

    public static <T> ResultVO<T> ok(T data,String msg){
        return new ResultVO(msg,data,SUCCESS);
    }

    public  static <T> ResultVO fail(){
        return new ResultVO(ERROR,ERROR,ERROR);
    }

    public  static <T> ResultVO fail(T data){
        return new ResultVO(ERROR,data,ERROR);
    }

    public  static <T> ResultVO fail(T data,String msg){
        return new ResultVO(ERROR,data,msg);
    }
    public  static <T> ResultVO fail(T data,String msg,int code){
        return new ResultVO(ERROR,data,ERROR);
    }
}















package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lyc
 * @date 2019/8/13.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    int code;

    T data;

    String msg;

}
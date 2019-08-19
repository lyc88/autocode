package com.example.demo.bean;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(value = "编号")
    int code;

    @ApiModelProperty(value = "数据")
    T data;

    @ApiModelProperty(value = "信息")
    String msg;

}
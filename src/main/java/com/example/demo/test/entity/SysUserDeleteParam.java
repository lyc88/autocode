package com.example.demo.test.entity;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
/**
* 用户信息表
*
* @author lyc
* @date 2022-04-07 10:39:37
*/
@Data
public class SysUserDeleteParam{

    /**
     * 用户ID
     */
     @ApiModelProperty(value = "用户ID" ,required = true)
     private Long userId;









































}
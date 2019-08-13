package com.example.demo.test.entity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
* 用户名
*
* @author lyc
* @date 2019-08-13 17:36:37
*/
@Data
@TableName("user")
public class User{
    /**
    * 
    */
    @TableId
    private Integer id;

    /**
    * 
    */
    @TableField("name")
    private String name;

    /**
    * 
    */
    @TableField("age")
    private Integer age;

    /**
    * 
    */
    @TableField("create_date")
    private Date createDate;

}
package com.example.demo.test.entity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
* 
*
* @author lyc
* @date 2019-08-13 17:36:37
*/
@Data
@TableName("c")
public class C{
    /**
    * 
    */
    @TableId
    private Integer id;

    /**
    * 
    */
    @TableField("parent_id")
    private Integer parentId;

    /**
    * 
    */
    @TableField("name")
    private String name;

    /**
    * 
    */
    @TableField("path")
    private String path;

}
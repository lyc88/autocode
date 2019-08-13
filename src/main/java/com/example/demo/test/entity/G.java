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
@TableName("g")
public class G{
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
    @TableField("cId")
    private Integer cid;

    /**
    * 
    */
    @TableField("path")
    private String path;

}
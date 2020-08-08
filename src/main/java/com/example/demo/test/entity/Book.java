package com.example.demo.test.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
* 
*
* @author lyc
* @date 2020-08-08 12:57:38
*/
@Data
@TableName("book")
public class Book{
    /**
    * 
    */
    @ApiModelProperty(value = "" ,required = true)
    @NotNull(message = "不能为空")
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
    * 书名
    */
    @ApiModelProperty(value = "书名",required = true)
    @NotNull(message = "书名不能为空")
    @TableField("name")
    private String name;

    /**
    * 路径
    */
    @ApiModelProperty(value = "路径",required = true)
    @NotNull(message = "路径不能为空")
    @TableField("path")
    private String path;

    /**
    * 封面
    */
    @ApiModelProperty(value = "封面",required = true)
    @NotNull(message = "封面不能为空")
    @TableField("img")
    private String img;

    /**
    * 类型
    */
    @ApiModelProperty(value = "类型",required = true)
    @NotNull(message = "类型不能为空")
    @TableField("type")
    private String type;

    /**
    * 大小 size
    */
    @ApiModelProperty(value = "大小 size",required = true)
    @NotNull(message = "大小 size不能为空")
    @TableField("size")
    private Integer size;

}
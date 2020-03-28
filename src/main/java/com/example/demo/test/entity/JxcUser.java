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
* @date 2020-03-27 17:23:57
*/
@Data
@TableName("user")
public class JxcUser{
    /**
    * 
    */
    @ApiModelProperty(value = "" ,required = true)
    @NotNull(message = "不能为空")
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
    * 
    */
    @ApiModelProperty(value = "",required = true)
    @NotNull(message = "不能为空")
    @TableField("name")
    private String name;

}
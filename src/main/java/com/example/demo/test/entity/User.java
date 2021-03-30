package com.example.demo.test.entity;
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
* @date 2021-03-30 16:43:10
*/
@Data
@TableName("user")
public class User{
    /**
    * 
    */
    @ApiModelProperty(value = "" ,required = true)
    @NotNull(message = "不能为空")
    @TableId
    private Long id;

    /**
    * 
    */
    @ApiModelProperty(value = "")
    @TableField("created_date")
    private Date createdDate;

    /**
    * 
    */
    @ApiModelProperty(value = "")
    @TableField("last_update_date")
    private Date lastUpdateDate;

    /**
    * 
    */
    @ApiModelProperty(value = "")
    @TableField("address")
    private String address;

    /**
    * 
    */
    @ApiModelProperty(value = "")
    @TableField("email")
    private String email;

    /**
    * 
    */
    @ApiModelProperty(value = "")
    @TableField("mobile")
    private String mobile;

    /**
    * 
    */
    @ApiModelProperty(value = "",required = true)
    @NotNull(message = "不能为空")
    @TableField("name")
    private String name;

}
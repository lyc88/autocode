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
* @date 2020-03-26 19:19:50
*/
@Data
@TableName("t_goodstype")
public class JxcTGoodstype{
    /**
    * 
    */
    @ApiModelProperty(value = "" ,required = true)
    @NotNull(message = "不能为空")
    @TableId
    private Integer id;

    /**
    * 
    */
    @ApiModelProperty(value = "")
    @TableField("name")
    private String name;

    /**
    * 
    */
    @ApiModelProperty(value = "")
    @TableField("p_id")
    private Integer pId;

    /**
    * 
    */
    @ApiModelProperty(value = "")
    @TableField("state")
    private Integer state;

    /**
    * 
    */
    @ApiModelProperty(value = "")
    @TableField("icon")
    private String icon;

}
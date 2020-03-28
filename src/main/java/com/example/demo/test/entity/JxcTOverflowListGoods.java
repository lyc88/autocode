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
@TableName("t_overflow_list_goods")
public class JxcTOverflowListGoods{
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
    @TableField("code")
    private String code;

    /**
    * 
    */
    @ApiModelProperty(value = "")
    @TableField("model")
    private String model;

    /**
    * 
    */
    @ApiModelProperty(value = "")
    @TableField("name")
    private String name;

    /**
    * 
    */
    @ApiModelProperty(value = "",required = true)
    @NotNull(message = "不能为空")
    @TableField("num")
    private Float num;

    /**
    * 
    */
    @ApiModelProperty(value = "",required = true)
    @NotNull(message = "不能为空")
    @TableField("price")
    private Float price;

    /**
    * 
    */
    @ApiModelProperty(value = "",required = true)
    @NotNull(message = "不能为空")
    @TableField("total")
    private Float total;

    /**
    * 
    */
    @ApiModelProperty(value = "")
    @TableField("unit")
    private String unit;

    /**
    * 
    */
    @ApiModelProperty(value = "")
    @TableField("overflow_list_id")
    private Integer overflowListId;

    /**
    * 
    */
    @ApiModelProperty(value = "")
    @TableField("type_id")
    private Integer typeId;

    /**
    * 
    */
    @ApiModelProperty(value = "")
    @TableField("goods_id")
    private Integer goodsId;

    /**
    * 剩余数量
    */
    @ApiModelProperty(value = "剩余数量")
    @TableField("remaining_amount")
    private Float remainingAmount;

    /**
    * 创建时间
    */
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    /**
    * 默认为1 有效
    */
    @ApiModelProperty(value = "默认为1 有效",required = true)
    @NotNull(message = "默认为1 有效不能为空")
    @TableField("status")
    private Integer status;

    /**
    * 是否仓库调拨0否 1是，多仓
    */
    @ApiModelProperty(value = "是否仓库调拨0否 1是，多仓")
    @TableField("transfer")
    private Integer transfer;

    /**
    * 利润
    */
    @ApiModelProperty(value = "利润")
    @TableField("profit")
    private Float profit;

}
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
@TableName("t_purchase_list_goods")
public class JxcTPurchaseListGoods{
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
    @TableField("purchase_list_id")
    private Integer purchaseListId;

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
    * 创建时间
    */
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    /**
    * 入库时商品剩余 数量
    */
    @ApiModelProperty(value = "入库时商品剩余 数量")
    @TableField("remaining_amount")
    private Float remainingAmount;

    /**
    * 储存位置
    */
    @ApiModelProperty(value = "储存位置")
    @TableField("storage_location")
    private String storageLocation;

    /**
    * 生成日期
    */
    @ApiModelProperty(value = "生成日期")
    @TableField("build_date")
    private Date buildDate;

    /**
    * 保质期 单位天
    */
    @ApiModelProperty(value = "保质期 单位天")
    @TableField("shelf_life")
    private Float shelfLife;

    /**
    * 1为有效
    */
    @ApiModelProperty(value = "1为有效",required = true)
    @NotNull(message = "1为有效不能为空")
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

    /**
    * 毛重
    */
    @ApiModelProperty(value = "毛重")
    @TableField("gross_weight")
    private Float grossWeight;

    /**
    * 毛重价
    */
    @ApiModelProperty(value = "毛重价")
    @TableField("gross_price")
    private Float grossPrice;

    /**
    * 是否赠品 0 否 1 是
    */
    @ApiModelProperty(value = "是否赠品 0 否 1 是",required = true)
    @NotNull(message = "是否赠品 0 否 1 是不能为空")
    @TableField("giveaway")
    private Integer giveaway;

}
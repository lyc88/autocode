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
@TableName("t_goods")
public class JxcTGoods{
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
    @ApiModelProperty(value = "",required = true)
    @NotNull(message = "不能为空")
    @TableField("inventory_quantity")
    private Float inventoryQuantity;

    /**
    * 
    */
    @ApiModelProperty(value = "",required = true)
    @NotNull(message = "不能为空")
    @TableField("min_num")
    private Float minNum;

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
    @ApiModelProperty(value = "")
    @TableField("producer")
    private String producer;

    /**
    * 
    */
    @ApiModelProperty(value = "",required = true)
    @NotNull(message = "不能为空")
    @TableField("purchasing_price")
    private Float purchasingPrice;

    /**
    * 
    */
    @ApiModelProperty(value = "")
    @TableField("remarks")
    private String remarks;

    /**
    * 
    */
    @ApiModelProperty(value = "",required = true)
    @NotNull(message = "不能为空")
    @TableField("selling_price")
    private Float sellingPrice;

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
    @TableField("type_id")
    private Integer typeId;

    /**
    * 
    */
    @ApiModelProperty(value = "",required = true)
    @NotNull(message = "不能为空")
    @TableField("state")
    private Integer state;

    /**
    * 
    */
    @ApiModelProperty(value = "",required = true)
    @NotNull(message = "不能为空")
    @TableField("last_purchasing_price")
    private Float lastPurchasingPrice;

    /**
    * 是否是基础商品1是 0 不是
    */
    @ApiModelProperty(value = "是否是基础商品1是 0 不是",required = true)
    @NotNull(message = "是否是基础商品1是 0 不是不能为空")
    @TableField("base")
    private Integer base;

    /**
    * 不是基础商品 需维护对应 的基础商品
    */
    @ApiModelProperty(value = "不是基础商品 需维护对应 的基础商品",required = true)
    @NotNull(message = "不是基础商品 需维护对应 的基础商品不能为空")
    @TableField("base_goods")
    private String baseGoods;

    /**
    * 换算关系 不是基础商品对应基础商品的换算关系如 1箱为16个
    */
    @ApiModelProperty(value = "换算关系 不是基础商品对应基础商品的换算关系如 1箱为16个",required = true)
    @NotNull(message = "换算关系 不是基础商品对应基础商品的换算关系如 1箱为16个不能为空")
    @TableField("relationship")
    private Float relationship;

    /**
    * 最后入库时间
    */
    @ApiModelProperty(value = "最后入库时间")
    @TableField("last_storage_time")
    private Date lastStorageTime;

    /**
    * 分类路径逗号分隔
    */
    @ApiModelProperty(value = "分类路径逗号分隔")
    @TableField("path")
    private String path;

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
    * 储存位置
    */
    @ApiModelProperty(value = "储存位置")
    @TableField("storage_location")
    private String storageLocation;

    /**
    * 货值，采购入库采购价和数量+ 出库也会算-
    */
    @ApiModelProperty(value = "货值，采购入库采购价和数量+ 出库也会算-")
    @TableField("amount")
    private BigDecimal amount;

    /**
    * 0正常1删除
    */
    @ApiModelProperty(value = "0正常1删除",required = true)
    @NotNull(message = "0正常1删除不能为空")
    @TableField("status")
    private Integer status;

    /**
    * 商品重量克g
    */
    @ApiModelProperty(value = "商品重量克g")
    @TableField("weight")
    private Integer weight;

    /**
    * 冻结库存数
    */
    @ApiModelProperty(value = "冻结库存数")
    @TableField("freeze")
    private Float freeze;

    /**
    * 版本号
    */
    @ApiModelProperty(value = "版本号")
    @TableField("version")
    private Integer version;

    /**
    * 是否打印重量0 否1 是
    */
    @ApiModelProperty(value = "是否打印重量0 否1 是")
    @TableField("print_weight")
    private Integer printWeight;

}
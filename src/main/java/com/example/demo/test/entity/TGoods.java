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
* 商品表
*
* @author lyc
* @date 2020-03-26 18:07:49
*/
@Data
@TableName("t_goods")
public class TGoods{
    /**
    * 主键
    */
    @ApiModelProperty(value = "主键" ,required = true)
    @NotNull(message = "主键不能为空")
    @TableId
    private Long id;

    /**
    * 1标品|2非标品
    */
    @ApiModelProperty(value = "1标品|2非标品")
    @TableField("categories_id")
    private Integer categoriesId;

    /**
    * 粮油瓜果蔬菜
    */
    @ApiModelProperty(value = "粮油瓜果蔬菜")
    @TableField("product_category_id")
    private Long productCategoryId;

    /**
    * 瓜果粮油
    */
    @ApiModelProperty(value = "瓜果粮油")
    @TableField("product_category")
    private String productCategory;

    /**
    * 瓜果粮油二级ID
    */
    @ApiModelProperty(value = "瓜果粮油二级ID")
    @TableField("product_category_two_id")
    private Long productCategoryTwoId;

    /**
    * 瓜果粮油二级
    */
    @ApiModelProperty(value = "瓜果粮油二级")
    @TableField("product_category_two")
    private String productCategoryTwo;

    /**
    * 条码
    */
    @ApiModelProperty(value = "条码")
    @TableField("barcode")
    private String barcode;

    /**
    * 编号
    */
    @ApiModelProperty(value = "编号")
    @TableField("code")
    private String code;

    /**
    * 名称
    */
    @ApiModelProperty(value = "名称")
    @TableField("name")
    private String name;

    /**
    * 规格型号
    */
    @ApiModelProperty(value = "规格型号")
    @TableField("standard")
    private String standard;

    /**
    * 单位id
    */
    @ApiModelProperty(value = "单位id")
    @TableField("unit_id")
    private Long unitId;

    /**
    * 单位
    */
    @ApiModelProperty(value = "单位")
    @TableField("unit")
    private String unit;

    /**
    * 保质期
    */
    @ApiModelProperty(value = "保质期")
    @TableField("life")
    private Integer life;

    /**
    * 重量KG
    */
    @ApiModelProperty(value = "重量KG")
    @TableField("weight")
    private BigDecimal weight;

    /**
    * 长,单位CM
    */
    @ApiModelProperty(value = "长,单位CM")
    @TableField("length")
    private BigDecimal length;

    /**
    * 宽,单位CM
    */
    @ApiModelProperty(value = "宽,单位CM")
    @TableField("width")
    private BigDecimal width;

    /**
    * 高,单位CM
    */
    @ApiModelProperty(value = "高,单位CM")
    @TableField("high")
    private BigDecimal high;

    /**
    * 体积
    */
    @ApiModelProperty(value = "体积")
    @TableField("volumes")
    private BigDecimal volumes;

    /**
    * 安全库存,0表示未设置
    */
    @ApiModelProperty(value = "安全库存,0表示未设置")
    @TableField("safe_quantity")
    private Integer safeQuantity;

    /**
    * 1常温|2冷藏|3冷冻
    */
    @ApiModelProperty(value = "1常温|2冷藏|3冷冻")
    @TableField("storage_type_id")
    private Integer storageTypeId;

    /**
    * 图片地址
    */
    @ApiModelProperty(value = "图片地址")
    @TableField("picture")
    private String picture;

    /**
    * 说明
    */
    @ApiModelProperty(value = "说明")
    @TableField("comment")
    private String comment;

    /**
    * 创建用户ID
    */
    @ApiModelProperty(value = "创建用户ID")
    @TableField("created_user_id")
    private Long createdUserId;

    /**
    * 创建者
    */
    @ApiModelProperty(value = "创建者")
    @TableField("created_user")
    private String createdUser;

    /**
    * 创建时间
    */
    @ApiModelProperty(value = "创建时间")
    @TableField("created_time")
    private Date createdTime;

    /**
    * 最后修改时间
    */
    @ApiModelProperty(value = "最后修改时间")
    @TableField("last_modified_time")
    private Date lastModifiedTime;

    /**
    * 1启用|0停用
    */
    @ApiModelProperty(value = "1启用|0停用")
    @TableField("is_enabled")
    private Boolean isEnabled;

    /**
    * 版本
    */
    @ApiModelProperty(value = "版本")
    @TableField("version")
    private Long version;

    /**
    * 1删除|0存在
    */
    @ApiModelProperty(value = "1删除|0存在")
    @TableField("is_delete")
    private Boolean isDelete;

}
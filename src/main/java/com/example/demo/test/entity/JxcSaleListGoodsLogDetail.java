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
* 销售出库记录详细表
*
* @author lyc
* @date 2020-03-26 19:19:50
*/
@Data
@TableName("sale_list_goods_log_detail")
public class JxcSaleListGoodsLogDetail{
    /**
    * 
    */
    @ApiModelProperty(value = "" ,required = true)
    @NotNull(message = "不能为空")
    @TableId
    private Integer id;

    /**
    * 销售出库详细商品记录id
    */
    @ApiModelProperty(value = "销售出库详细商品记录id",required = true)
    @NotNull(message = "销售出库详细商品记录id不能为空")
    @TableField("sale_list_goods_log_id")
    private Integer saleListGoodsLogId;

    /**
    * 编码
    */
    @ApiModelProperty(value = "编码",required = true)
    @NotNull(message = "编码不能为空")
    @TableField("number")
    private String number;

    /**
    * 
    */
    @ApiModelProperty(value = "",required = true)
    @NotNull(message = "不能为空")
    @TableField("remark")
    private String remark;

    /**
    * 价格
    */
    @ApiModelProperty(value = "价格",required = true)
    @NotNull(message = "价格不能为空")
    @TableField("price")
    private Float price;

    /**
    * 数量
    */
    @ApiModelProperty(value = "数量",required = true)
    @NotNull(message = "数量不能为空")
    @TableField("num")
    private Float num;

    /**
    * 总价
    */
    @ApiModelProperty(value = "总价",required = true)
    @NotNull(message = "总价不能为空")
    @TableField("total")
    private Float total;

    /**
    * 创建时间
    */
    @ApiModelProperty(value = "创建时间",required = true)
    @NotNull(message = "创建时间不能为空")
    @TableField("create_time")
    private Date createTime;

    /**
    * 0 采购 1报溢 2 客户退货
    */
    @ApiModelProperty(value = "0 采购 1报溢 2 客户退货",required = true)
    @NotNull(message = "0 采购 1报溢 2 客户退货不能为空")
    @TableField("type")
    private Integer type;

    /**
    * 具体的项id 如采购项id
    */
    @ApiModelProperty(value = "具体的项id 如采购项id",required = true)
    @NotNull(message = "具体的项id 如采购项id不能为空")
    @TableField("item_id")
    private Integer itemId;

}
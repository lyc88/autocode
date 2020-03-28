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
* 销售出库成本价记录表
*
* @author lyc
* @date 2020-03-26 19:19:50
*/
@Data
@TableName("sale_list_goods_log")
public class JxcSaleListGoodsLog{
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
    @TableField("sale_list_goods_id")
    private Integer saleListGoodsId;

    /**
    * 创建时间
    */
    @ApiModelProperty(value = "创建时间",required = true)
    @NotNull(message = "创建时间不能为空")
    @TableField("create_time")
    private Date createTime;

}
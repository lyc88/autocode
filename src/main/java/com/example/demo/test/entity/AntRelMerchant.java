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
* 蚂蚁门店 传贝门店关联
*
* @author lyc
* @date 2020-12-24 14:04:14
*/
@Data
@TableName("ant_rel_merchant")
public class AntRelMerchant{
    /**
    * id
    */
    @ApiModelProperty(value = "id" ,required = true)
    @NotNull(message = "id不能为空")
    @TableId
    private Long id;

    /**
    * 关联传贝门店id
    */
    @ApiModelProperty(value = "关联传贝门店id",required = true)
    @NotNull(message = "关联传贝门店id不能为空")
    @TableField("relation_store_id")
    private Integer relationStoreId;

    /**
    * 蚂蚁门店id
    */
    @ApiModelProperty(value = "蚂蚁门店id",required = true)
    @NotNull(message = "蚂蚁门店id不能为空")
    @TableField("ant_merchant_id")
    private Integer antMerchantId;

    /**
    * 创建人
    */
    @ApiModelProperty(value = "创建人",required = true)
    @NotNull(message = "创建人不能为空")
    @TableField("create_by")
    private String createBy;

    /**
    * 创建时间
    */
    @ApiModelProperty(value = "创建时间",required = true)
    @NotNull(message = "创建时间不能为空")
    @TableField("create_time")
    private Long createTime;

    /**
    * 更新人
    */
    @ApiModelProperty(value = "更新人",required = true)
    @NotNull(message = "更新人不能为空")
    @TableField("update_by")
    private String updateBy;

    /**
    * 更新时间
    */
    @ApiModelProperty(value = "更新时间",required = true)
    @NotNull(message = "更新时间不能为空")
    @TableField("update_time")
    private Long updateTime;

}
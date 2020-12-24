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
* 支付宝门店类目
*
* @author lyc
* @date 2020-12-24 14:02:36
*/
@Data
@TableName("ant_category")
public class AntCategory{
    /**
    * id
    */
    @ApiModelProperty(value = "id" ,required = true)
    @NotNull(message = "id不能为空")
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
    * 类目名称
    */
    @ApiModelProperty(value = "类目名称",required = true)
    @NotNull(message = "类目名称不能为空")
    @TableField("category_name")
    private String categoryName;

    /**
    * 类目编码
    */
    @ApiModelProperty(value = "类目编码",required = true)
    @NotNull(message = "类目编码不能为空")
    @TableField("category_code")
    private String categoryCode;

    /**
    * MCC码
    */
    @ApiModelProperty(value = "MCC码",required = true)
    @NotNull(message = "MCC码不能为空")
    @TableField("mmc_code")
    private String mmcCode;

    /**
    * 是否需要审核 0 否 1是
    */
    @ApiModelProperty(value = "是否需要审核 0 否 1是",required = true)
    @NotNull(message = "是否需要审核 0 否 1是不能为空")
    @TableField("review")
    private Integer review;

    /**
    * 门店类目认证标准
    */
    @ApiModelProperty(value = "门店类目认证标准",required = true)
    @NotNull(message = "门店类目认证标准不能为空")
    @TableField("category_certification_standards")
    private String categoryCertificationStandards;

    /**
    * 门店资质组名称
    */
    @ApiModelProperty(value = "门店资质组名称",required = true)
    @NotNull(message = "门店资质组名称不能为空")
    @TableField("qualification_group")
    private String qualificationGroup;

    /**
    * 门店业务方
    */
    @ApiModelProperty(value = "门店业务方",required = true)
    @NotNull(message = "门店业务方不能为空")
    @TableField("store_business")
    private String storeBusiness;

    /**
    * 父code
    */
    @ApiModelProperty(value = "父code",required = true)
    @NotNull(message = "父code不能为空")
    @TableField("parent_code")
    private String parentCode;

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
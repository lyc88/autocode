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
* 产品种类
*
* @author lyc
* @date 2020-03-26 18:08:51
*/
@Data
@TableName("t_product_category")
public class TProductCategory{
    /**
    * 主键
    */
    @ApiModelProperty(value = "主键" ,required = true)
    @NotNull(message = "主键不能为空")
    @TableId
    private Long id;

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

    /**
    * 父节点
    */
    @ApiModelProperty(value = "父节点")
    @TableField("p_id")
    private Long pId;

    /**
    * 层级
    */
    @ApiModelProperty(value = "层级")
    @TableField("grade_id")
    private Long gradeId;

    /**
    * 路径
    */
    @ApiModelProperty(value = "路径")
    @TableField("path")
    private String path;

    /**
    * 创建人
    */
    @ApiModelProperty(value = "创建人")
    @TableField("created_user")
    private String createdUser;

    /**
    * 创建人id
    */
    @ApiModelProperty(value = "创建人id")
    @TableField("created_user_id")
    private Long createdUserId;

}
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
* 产品单位
*
* @author lyc
* @date 2020-03-26 18:09:39
*/
@Data
@TableName("t_unit")
public class TUnit{
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

}
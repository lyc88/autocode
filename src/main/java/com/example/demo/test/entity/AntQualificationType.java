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
* 蚂蚁行业资质类型
*
* @author lyc
* @date 2020-12-24 14:03:36
*/
@Data
@TableName("ant_qualification_type")
public class AntQualificationType{
    /**
    * id
    */
    @ApiModelProperty(value = "id" ,required = true)
    @NotNull(message = "id不能为空")
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
    * 行业资质类型
    */
    @ApiModelProperty(value = "行业资质类型",required = true)
    @NotNull(message = "行业资质类型不能为空")
    @TableField("cert_type")
    private String certType;

    /**
    * 行业资质类型对应的code
    */
    @ApiModelProperty(value = "行业资质类型对应的code",required = true)
    @NotNull(message = "行业资质类型对应的code不能为空")
    @TableField("cert_code")
    private String certCode;

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
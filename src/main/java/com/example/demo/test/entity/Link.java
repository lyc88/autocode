package com.example.demo.test.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

/**
* 
*
* @author lyc
* @date 2020-07-08 14:21:51
*/
@Data
@TableName("link")
public class Link{
    /**
    * 
    */
    @ApiModelProperty(value = "" ,required = true)
    @NotNull(message = "不能为空")
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
    * 标题
    */
    @ApiModelProperty(value = "标题",required = true)
    @NotNull(message = "标题不能为空")
    @TableField("title")
    private String title;

    /**
    * 描述
    */
    @ApiModelProperty(value = "描述",required = true)
    @NotNull(message = "描述不能为空")
    @TableField("summary")
    private String desc;

    /**
    * 来源 gitee ,github
    */
    @ApiModelProperty(value = "来源 gitee ,github",required = true)
    @NotNull(message = "来源 gitee ,github不能为空")
    @TableField("source")
    private String source;

    /**
    * 创建时间
    */
    @ApiModelProperty(value = "创建时间",required = true)
    @NotNull(message = "创建时间不能为空")
    @TableField("create_time")
    private Date createTime;

    /**
    * 最后修改时间
    */
    @ApiModelProperty(value = "最后修改时间",required = true)
    @NotNull(message = "最后修改时间不能为空")
    @TableField("update_time")
    private Date updateTime;

    /**
    * 链接
    */
    @ApiModelProperty(value = "链接",required = true)
    @NotNull(message = "链接不能为空")
    @TableField("link")
    private String link;

}
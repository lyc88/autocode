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
* 蚂蚁区域码
*
* @author lyc
* @date 2020-12-24 14:01:46
*/
@Data
@TableName("ant_area")
public class AntArea{
    /**
    * id
    */
    @ApiModelProperty(value = "id" ,required = true)
    @NotNull(message = "id不能为空")
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
    * 地区标示符
    */
    @ApiModelProperty(value = "地区标示符",required = true)
    @NotNull(message = "地区标示符不能为空")
    @TableField("identification")
    private String identification;

    /**
    * 中文简称
    */
    @ApiModelProperty(value = "中文简称",required = true)
    @NotNull(message = "中文简称不能为空")
    @TableField("short_name")
    private String shortName;

    /**
    * 地区码
    */
    @ApiModelProperty(value = "地区码",required = true)
    @NotNull(message = "地区码不能为空")
    @TableField("area_code")
    private String areaCode;

    /**
    * 简称拼音
    */
    @ApiModelProperty(value = "简称拼音",required = true)
    @NotNull(message = "简称拼音不能为空")
    @TableField("short_pinyin")
    private String shortPinyin;

    /**
    * 全拼
    */
    @ApiModelProperty(value = "全拼",required = true)
    @NotNull(message = "全拼不能为空")
    @TableField("full_pinyin")
    private String fullPinyin;

    /**
    * 区域名称
    */
    @ApiModelProperty(value = "区域名称",required = true)
    @NotNull(message = "区域名称不能为空")
    @TableField("full_name")
    private String fullName;

    /**
    * 上级区域编码
    */
    @ApiModelProperty(value = "上级区域编码",required = true)
    @NotNull(message = "上级区域编码不能为空")
    @TableField("parent_code")
    private String parentCode;

    /**
    * 拼音首字母
    */
    @ApiModelProperty(value = "拼音首字母",required = true)
    @NotNull(message = "拼音首字母不能为空")
    @TableField("initials")
    private String initials;

    /**
    * 区域类型 1 国家 2 省 3 市 4 县区
    */
    @ApiModelProperty(value = "区域类型 1 国家 2 省 3 市 4 县区",required = true)
    @NotNull(message = "区域类型 1 国家 2 省 3 市 4 县区不能为空")
    @TableField("area_type")
    private Integer areaType;

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
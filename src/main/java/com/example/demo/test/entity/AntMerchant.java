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
* 蚂蚁 门店
*
* @author lyc
* @date 2020-12-24 14:03:06
*/
@Data
@TableName("ant_merchant")
public class AntMerchant{
    /**
    * 主键id
    */
    @ApiModelProperty(value = "主键id" ,required = true)
    @NotNull(message = "主键id不能为空")
    @TableId
    private Long id;

    /**
    * 店铺名称
    */
    @ApiModelProperty(value = "店铺名称",required = true)
    @NotNull(message = "店铺名称不能为空")
    @TableField("shop_name")
    private String shopName;

    /**
    * 店铺经营类型，1表示直营，2表示加盟
    */
    @ApiModelProperty(value = "店铺经营类型，1表示直营，2表示加盟",required = true)
    @NotNull(message = "店铺经营类型，1表示直营，2表示加盟不能为空")
    @TableField("shop_type")
    private Integer shopType;

    /**
    * 省id
    */
    @ApiModelProperty(value = "省id",required = true)
    @NotNull(message = "省id不能为空")
    @TableField("province_id")
    private Integer provinceId;

    /**
    * 省名称
    */
    @ApiModelProperty(value = "省名称",required = true)
    @NotNull(message = "省名称不能为空")
    @TableField("province_name")
    private String provinceName;

    /**
    * 城市id
    */
    @ApiModelProperty(value = "城市id",required = true)
    @NotNull(message = "城市id不能为空")
    @TableField("city_id")
    private Integer cityId;

    /**
    * 城市名称
    */
    @ApiModelProperty(value = "城市名称",required = true)
    @NotNull(message = "城市名称不能为空")
    @TableField("city_name")
    private String cityName;

    /**
    * 县区id
    */
    @ApiModelProperty(value = "县区id",required = true)
    @NotNull(message = "县区id不能为空")
    @TableField("county_id")
    private Integer countyId;

    /**
    * 县区名称
    */
    @ApiModelProperty(value = "县区名称",required = true)
    @NotNull(message = "县区名称不能为空")
    @TableField("county_name")
    private String countyName;

    /**
    * 详细地址
    */
    @ApiModelProperty(value = "详细地址",required = true)
    @NotNull(message = "详细地址不能为空")
    @TableField("address")
    private String address;

    /**
    * 一级类目id
    */
    @ApiModelProperty(value = "一级类目id",required = true)
    @NotNull(message = "一级类目id不能为空")
    @TableField("category1_id")
    private Integer category1Id;

    /**
    * 一级类目名称
    */
    @ApiModelProperty(value = "一级类目名称",required = true)
    @NotNull(message = "一级类目名称不能为空")
    @TableField("category1_name")
    private String category1Name;

    /**
    * 二级类目id
    */
    @ApiModelProperty(value = "二级类目id",required = true)
    @NotNull(message = "二级类目id不能为空")
    @TableField("category2_id")
    private Integer category2Id;

    /**
    * 二级类目名称
    */
    @ApiModelProperty(value = "二级类目名称",required = true)
    @NotNull(message = "二级类目名称不能为空")
    @TableField("category2_name")
    private String category2Name;

    /**
    * 三级类目id
    */
    @ApiModelProperty(value = "三级类目id",required = true)
    @NotNull(message = "三级类目id不能为空")
    @TableField("category3_id")
    private Integer category3Id;

    /**
    * 三级类目名称
    */
    @ApiModelProperty(value = "三级类目名称",required = true)
    @NotNull(message = "三级类目名称不能为空")
    @TableField("category3_name")
    private String category3Name;

    /**
    * 联系方式 固话或者手机
    */
    @ApiModelProperty(value = "联系方式 固话或者手机",required = true)
    @NotNull(message = "联系方式 固话或者手机不能为空")
    @TableField("phone")
    private String phone;

    /**
    * 备注
    */
    @ApiModelProperty(value = "备注",required = true)
    @NotNull(message = "备注不能为空")
    @TableField("memo")
    private String memo;

    /**
    * 法人名称
    */
    @ApiModelProperty(value = "法人名称",required = true)
    @NotNull(message = "法人名称不能为空")
    @TableField("legal_name")
    private String legalName;

    /**
    * 法人身份证
    */
    @ApiModelProperty(value = "法人身份证",required = true)
    @NotNull(message = "法人身份证不能为空")
    @TableField("legal_cert_no")
    private String legalCertNo;

    /**
    * 证件号码(店铺营业执照号)
    */
    @ApiModelProperty(value = "证件号码(店铺营业执照号)",required = true)
    @NotNull(message = "证件号码(店铺营业执照号)不能为空")
    @TableField("cert_no")
    private String certNo;

    /**
    * 商户行业资质类型
    */
    @ApiModelProperty(value = "商户行业资质类型",required = true)
    @NotNull(message = "商户行业资质类型不能为空")
    @TableField("industry_qualification_type")
    private String industryQualificationType;

    /**
    * 商户行业资质图片
    */
    @ApiModelProperty(value = "商户行业资质图片",required = true)
    @NotNull(message = "商户行业资质图片不能为空")
    @TableField("industry_qualification_image")
    private String industryQualificationImage;

    /**
    * 1 营业执照 2 统一社会信用代码
    */
    @ApiModelProperty(value = "1 营业执照 2 统一社会信用代码",required = true)
    @NotNull(message = "1 营业执照 2 统一社会信用代码不能为空")
    @TableField("cert_type")
    private Integer certType;

    /**
    * 营业执照名称，填写值为营业执照或统一社会信用代码证上的名称
    */
    @ApiModelProperty(value = "营业执照名称，填写值为营业执照或统一社会信用代码证上的名称",required = true)
    @NotNull(message = "营业执照名称，填写值为营业执照或统一社会信用代码证上的名称不能为空")
    @TableField("cert_name")
    private String certName;

    /**
    * 营业执照图片
    */
    @ApiModelProperty(value = "营业执照图片",required = true)
    @NotNull(message = "营业执照图片不能为空")
    @TableField("cert_image")
    private String certImage;

    /**
    * 营业执照授权函
    */
    @ApiModelProperty(value = "营业执照授权函",required = true)
    @NotNull(message = "营业执照授权函不能为空")
    @TableField("license_auth_letter_image")
    private String licenseAuthLetterImage;

    /**
    * 门头照片
    */
    @ApiModelProperty(value = "门头照片",required = true)
    @NotNull(message = "门头照片不能为空")
    @TableField("out_door_images")
    private String outDoorImages;

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

    /**
    * 申请单id
    */
    @ApiModelProperty(value = "申请单id",required = true)
    @NotNull(message = "申请单id不能为空")
    @TableField("order_id")
    private String orderId;

    /**
    * 店铺状态 0 已提交 1 已完结 2 失败 3 关闭
    */
    @ApiModelProperty(value = "店铺状态 0 已提交 1 已完结 2 失败 3 关闭",required = true)
    @NotNull(message = "店铺状态 0 已提交 1 已完结 2 失败 3 关闭不能为空")
    @TableField("shop_status")
    private Integer shopStatus;

}
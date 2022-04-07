package com.example.demo.test.entity;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
* 用户信息表
*
* @author lyc
* @date 2022-04-07 10:39:37
*/
@Data
public class SysUserUpdateParam{
    /**
    * 用户ID
    */
    @ApiModelProperty(value = "用户ID" ,required = true)
    private Long userId;

    /**
    * 部门ID
    */
    @ApiModelProperty(value = "部门ID" )
    private Long deptId;

    /**
    * 登录账号
    */
    @ApiModelProperty(value = "登录账号" ,required = true)
    private String loginName;

    /**
    * 用户昵称
    */
    @ApiModelProperty(value = "用户昵称" )
    private String userName;

    /**
    * 用户类型（00系统用户 01注册用户）
    */
    @ApiModelProperty(value = "用户类型（00系统用户 01注册用户）" )
    private String userType;

    /**
    * 用户邮箱
    */
    @ApiModelProperty(value = "用户邮箱" )
    private String email;

    /**
    * 手机号码
    */
    @ApiModelProperty(value = "手机号码" )
    private String phonenumber;

    /**
    * 用户性别（0男 1女 2未知）
    */
    @ApiModelProperty(value = "用户性别（0男 1女 2未知）" )
    private String sex;

    /**
    * 头像路径
    */
    @ApiModelProperty(value = "头像路径" )
    private String avatar;

    /**
    * 密码
    */
    @ApiModelProperty(value = "密码" )
    private String password;

    /**
    * 盐加密
    */
    @ApiModelProperty(value = "盐加密" )
    private String salt;

    /**
    * 帐号状态（0正常 1停用）
    */
    @ApiModelProperty(value = "帐号状态（0正常 1停用）" )
    private String status;

    /**
    * 删除标志（0代表存在 2代表删除）
    */
    @ApiModelProperty(value = "删除标志（0代表存在 2代表删除）" )
    private String delFlag;

    /**
    * 最后登录IP
    */
    @ApiModelProperty(value = "最后登录IP" )
    private String loginIp;

    /**
    * 最后登录时间
    */
    @ApiModelProperty(value = "最后登录时间" )
    private Date loginDate;

    /**
    * 密码最后更新时间
    */
    @ApiModelProperty(value = "密码最后更新时间" )
    private Date pwdUpdateDate;

    /**
    * 创建者
    */
    @ApiModelProperty(value = "创建者" )
    private String createBy;

    /**
    * 创建时间
    */
    @ApiModelProperty(value = "创建时间" )
    private Date createTime;

    /**
    * 更新者
    */
    @ApiModelProperty(value = "更新者" )
    private String updateBy;

    /**
    * 更新时间
    */
    @ApiModelProperty(value = "更新时间" )
    private Date updateTime;

    /**
    * 备注
    */
    @ApiModelProperty(value = "备注" )
    private String remark;

}
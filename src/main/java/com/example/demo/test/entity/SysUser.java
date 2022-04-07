package com.example.demo.test.entity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.FieldFill;
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
@TableName("sys_user")
public class SysUser{
    /**
    * 用户ID
    */
    @ApiModelProperty(value = "用户ID" ,required = true)
    @NotNull(message = "用户ID不能为空")
    @TableId
    private Long userId;

    /**
    * 部门ID
    */
    @ApiModelProperty(value = "部门ID")
    @TableField("dept_id")
    private Long deptId;

    /**
    * 登录账号
    */
    @ApiModelProperty(value = "登录账号",required = true)
    @NotNull(message = "登录账号不能为空")
    @TableField("login_name")
    private String loginName;

    /**
    * 用户昵称
    */
    @ApiModelProperty(value = "用户昵称")
    @TableField("user_name")
    private String userName;

    /**
    * 用户类型（00系统用户 01注册用户）
    */
    @ApiModelProperty(value = "用户类型（00系统用户 01注册用户）")
    @TableField("user_type")
    private String userType;

    /**
    * 用户邮箱
    */
    @ApiModelProperty(value = "用户邮箱")
    @TableField("email")
    private String email;

    /**
    * 手机号码
    */
    @ApiModelProperty(value = "手机号码")
    @TableField("phonenumber")
    private String phonenumber;

    /**
    * 用户性别（0男 1女 2未知）
    */
    @ApiModelProperty(value = "用户性别（0男 1女 2未知）")
    @TableField("sex")
    private String sex;

    /**
    * 头像路径
    */
    @ApiModelProperty(value = "头像路径")
    @TableField("avatar")
    private String avatar;

    /**
    * 密码
    */
    @ApiModelProperty(value = "密码")
    @TableField("password")
    private String password;

    /**
    * 盐加密
    */
    @ApiModelProperty(value = "盐加密")
    @TableField("salt")
    private String salt;

    /**
    * 帐号状态（0正常 1停用）
    */
    @ApiModelProperty(value = "帐号状态（0正常 1停用）")
    @TableField("status")
    private String status;

    /**
    * 删除标志（0代表存在 2代表删除）
    */
    @ApiModelProperty(value = "删除标志（0代表存在 2代表删除）")
    @TableField("del_flag")
    private String delFlag;

    /**
    * 最后登录IP
    */
    @ApiModelProperty(value = "最后登录IP")
    @TableField("login_ip")
    private String loginIp;

    /**
    * 最后登录时间
    */
    @ApiModelProperty(value = "最后登录时间")
    @TableField("login_date")
    private Date loginDate;

    /**
    * 密码最后更新时间
    */
    @ApiModelProperty(value = "密码最后更新时间")
    @TableField("pwd_update_date")
    private Date pwdUpdateDate;

    /**
    * 创建者
    */
    @ApiModelProperty(value = "创建者")
    @TableField("create_by")
    private String createBy;

    /**
    * 创建时间
    */
    @ApiModelProperty(value = "创建时间")
    @TableField(value="create_time",fill = FieldFill.INSERT)
    private Date createTime;

    /**
    * 更新者
    */
    @ApiModelProperty(value = "更新者")
    @TableField("update_by")
    private String updateBy;

    /**
    * 更新时间
    */
    @ApiModelProperty(value = "更新时间")
    @TableField(value="update_time",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


    /**
    * 备注
    */
    @ApiModelProperty(value = "备注")
    @TableField("remark")
    private String remark;

}
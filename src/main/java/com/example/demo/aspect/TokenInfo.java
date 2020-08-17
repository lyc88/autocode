package com.example.demo.aspect;

import lombok.Data;

/**
 * @author: lyc
 * @date: 2020/8/17 14:54
 * @describe
 */
@Data
public class TokenInfo {
    /** token类型: api:0 、user:1 */
    private Integer tokenType;

    /** App 信息 */
    private AppInfo appInfo;

    /** 用户其他数据 */
    private UserInfo userInfo;
}

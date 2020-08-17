package com.example.demo.aspect;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author: lyc
 * @date: 2020/8/17 14:53
 * @describe
 */
@Data
@AllArgsConstructor
public class AccessToken {
    /** token */
    private String token;

    /** 失效时间 */
    private Date expireTime;
}
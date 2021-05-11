package com.example.demo.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Author:   lyc
 * Date:     2020/6/19 14:42
 */
@Data
public class PageDto {
    @ApiModelProperty(value = "页大小 默认10 ,最大500",name = "limit")
    private Integer pageSize=10;

    @ApiModelProperty(value = "当前页 默认1 ",name = "page")
    private Integer pageNum=1;
}

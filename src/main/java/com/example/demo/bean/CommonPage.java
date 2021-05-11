package com.example.demo.bean;

import com.baomidou.mybatisplus.core.metadata.IPage;;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value="CommonPage对象", description="分页通用对象")
public class CommonPage<T> {
    @ApiModelProperty(value = "第几页")
    private Integer pageNum;
    @ApiModelProperty(value = "每页大小")
    private Integer pageSize;
    @ApiModelProperty(value = "总页数")
    private Integer totalPage;
    @ApiModelProperty(value = "总记录数")
    private Long total;
    @ApiModelProperty(value = "被分页对象")
    private List<T> list;



    /**
     *  mybatisplus 自带分页转换
     */
    public static <T> CommonPage<T> iPage( IPage<T> iPage) {
        CommonPage<T> result = new CommonPage<T>();
        result.setTotalPage((int) iPage.getPages());
        result.setPageNum((int) iPage.getCurrent());
        result.setPageSize((int) iPage.getSize());
        result.setTotal(iPage.getTotal());
        result.setList(iPage.getRecords());
        return result;
    }
}
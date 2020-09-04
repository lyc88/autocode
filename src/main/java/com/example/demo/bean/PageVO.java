package com.example.demo.bean;

import cn.hutool.core.util.PageUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author lyc
 * @date 2020/9/4 16:14
 * @describe
 */
@Data
@ApiModel(value = "分页VO")
@NoArgsConstructor
public class PageVO<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 总记录数
     */
    @ApiModelProperty(value = "总记录数")
    protected int totalCount;
    /**
     * 每页记录数
     */
    @ApiModelProperty(value = "每页记录数")
    protected int pageSize;
    /**
     * 总页数
     */
    @ApiModelProperty(value = "总页数")
    protected int totalPage;
    /**
     * 当前页数
     */
    @ApiModelProperty(value = "当前页数")
    protected int currPage;
    /**
     * 列表数据
     */
    @ApiModelProperty(value = "列表数据")
    protected List<T> list;

    /**
     * 分页
     *
     * @param list       列表数据
     * @param totalCount 总记录数
     * @param pageSize   每页记录数
     * @param currPage   当前页数
     */
    public PageVO(List<T> list, int totalCount, int pageSize, int currPage) {
        this.list = list;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.currPage = currPage;
        this.totalPage = (int) Math.ceil((double) totalCount / pageSize);
    }

    /**
     * 分页
     */
    public PageVO(IPage<T> page) {
        this.list = page.getRecords();
        this.totalCount = (int) page.getTotal();
        this.pageSize = (int) page.getSize();
        this.currPage = (int) page.getCurrent();
        this.totalPage = (int) page.getPages();
    }

    /**
     * 分页,兼容jpa的Page
     */
    public PageVO(Page page, Class<T> clazz) {
        this.list = JSON.parseArray(JSON.toJSONString(page.getContent()),clazz);
        this.totalCount = (int) page.getTotalElements();
        this.pageSize = page.getSize();
        this.currPage =  page.getNumber();
        this.totalPage =  page.getTotalPages();
    }


    /**
     * 分页,兼容Map的Page
     */
    public PageVO(Map page, Class<T> clazz, int pageSize) {
        this.list = JSON.parseArray(JSON.toJSONString(page.get("list")),clazz);
        this.totalCount = (int) page.get("totalCount");
        this.pageSize = pageSize;
        this.currPage = (int) page.get("currentPage");
        this.totalPage = PageUtil.totalPage(this.totalCount,this.pageSize);
    }
}

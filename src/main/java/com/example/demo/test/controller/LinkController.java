package com.example.demo.test.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.test.entity.Link;
import com.example.demo.test.service.LinkService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import com.example.demo.bean.CommonResult;
import com.example.demo.bean.CommonResultResponse;
import java.util.List;
/**
* 
* @author lyc
* @date 2020-07-20 17:51:51
*/
@Api(value = "",tags={"操作接口"})
@RestController
public class LinkController{

    @Autowired
    private LinkService linkService;

    /**
    * 分页查询 size 页大小 current 当前页
    */
    @ApiOperation(value = "分页",notes = "通用结果返回对象")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "size", value = "页大小 默认10", defaultValue = "10"),
    @ApiImplicitParam(name = "current", value = "当前页 默认1", defaultValue = "1")
    })
    @GetMapping("link/page")
    public CommonResult<Link> page(@RequestParam(name = "size",defaultValue = "10") Integer size,
                                                @RequestParam(name = "current",defaultValue = "1") Integer current){
        Page page = new Page(current,size);
        IPage result = linkService.page(page);
        List<Link>  linkList = result.getRecords();
        return  CommonResultResponse.ok(linkList);
    }

    /**
    * 列表
    */
    @ApiOperation(value = "列表",notes = "通用结果返回对象")
    @GetMapping("link/list")
    public CommonResult<List<Link>> list(){
        //List<Link> linkList = linkService.list(new QueryWrapper<Link>());
        List<Link> linkList = null;Lists.newArrayList();
       // Link link = new Link();
       // linkList.add(link);
        return  CommonResultResponse.ok(linkList);
    }

    /**
    *  id删除
    */
    @ApiOperation(value = "id删除",notes = "通用结果返回对象")
    @PostMapping("link/delete")
    public CommonResult<Boolean> delete(Integer id){
        Boolean success = linkService.removeById(id);
        return CommonResultResponse.ok(success);
    }

    /**
    *  id查询
    */
    @ApiOperation(value = "id查询",notes = "通用结果返回对象")
    @GetMapping("link/findById")
    public CommonResult<Link> findById(Integer id){
        Link link = linkService.getById(id);
        return CommonResultResponse.ok(link);
    }

     /**
      *  新增
      */
     @ApiOperation(value = "新增",notes = "通用结果返回对象")
     @PostMapping("link/add")
     public CommonResult<Boolean> add(Link link){
        Boolean success = linkService.save(link);
        return CommonResultResponse.ok(success);
     }
}
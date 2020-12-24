package com.example.demo.test.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.test.entity.AntArea;
import com.example.demo.test.service.AntAreaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import com.example.demo.bean.CommonResult;
import com.example.demo.bean.CommonResultResponse;
import java.util.List;
/**
* 蚂蚁区域码
* @author lyc
* @date 2020-12-24 14:01:46
*/
@Api(value = "蚂蚁区域码",tags={"蚂蚁区域码操作接口"})
@RestController
public class AntAreaController{

    @Autowired
    private AntAreaService antAreaService;

    /**
    * 分页查询 size 页大小 current 当前页
    */
    @ApiOperation(value = "分页",notes = "通用结果返回对象")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "size", value = "页大小 默认10", defaultValue = "10"),
    @ApiImplicitParam(name = "current", value = "当前页 默认1", defaultValue = "1")
    })
    @GetMapping("antArea/page")
    public CommonResult<AntArea> page(@RequestParam(name = "size",defaultValue = "10") Integer size,
                                                @RequestParam(name = "current",defaultValue = "1") Integer current){
        Page page = new Page(current,size);
        IPage result = antAreaService.page(page);
        List<AntArea>  antAreaList = result.getRecords();
        return  CommonResultResponse.ok(antAreaList);
    }

    /**
    * 列表
    */
    @ApiOperation(value = "列表",notes = "通用结果返回对象")
    @GetMapping("antArea/list")
    public CommonResult<AntArea> list(){
        List<AntArea> antAreaList = antAreaService.list(new QueryWrapper<AntArea>());
        return  CommonResultResponse.ok(antAreaList);
    }

    /**
    *  id删除
    */
    @ApiOperation(value = "id删除",notes = "通用结果返回对象")
    @PostMapping("antArea/delete")
    public CommonResult<Boolean> delete(Integer id){
        Boolean success = antAreaService.removeById(id);
        return CommonResultResponse.ok(success);
    }

    /**
    *  id查询
    */
    @ApiOperation(value = "id查询",notes = "通用结果返回对象")
    @GetMapping("antArea/findById")
    public CommonResult<AntArea> findById(Integer id){
        AntArea antArea = antAreaService.getById(id);
        return CommonResultResponse.ok(antArea);
    }

     /**
      *  新增
      */
     @ApiOperation(value = "新增",notes = "通用结果返回对象")
     @PostMapping("antArea/add")
     public CommonResult<Boolean> add(AntArea antArea){
        Boolean success = antAreaService.save(antArea);
        return CommonResultResponse.ok(success);
     }
}
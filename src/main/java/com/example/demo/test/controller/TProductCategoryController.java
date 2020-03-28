package com.example.demo.test.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.test.entity.TProductCategory;
import com.example.demo.test.service.TProductCategoryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import com.example.demo.bean.CommonResult;
import com.example.demo.bean.CommonResultResponse;
import java.util.List;
/**
* 产品种类
* @author lyc
* @date 2020-03-26 18:08:51
*/
@Api(value = "产品种类",tags={"产品种类操作接口"})
@RestController
public class TProductCategoryController{

    @Autowired
    private TProductCategoryService tProductCategoryService;

    /**
    * 分页查询 size 页大小 current 当前页
    */
    @ApiOperation(value = "分页",notes = "通用结果返回对象")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "size", value = "页大小 默认10", defaultValue = "10"),
    @ApiImplicitParam(name = "current", value = "当前页 默认1", defaultValue = "1")
    })
    @GetMapping("tProductCategory/page")
    public CommonResult<TProductCategory> page(@RequestParam(name = "size",defaultValue = "10") Integer size,
                                                @RequestParam(name = "current",defaultValue = "1") Integer current){
        Page page = new Page(current,size);
        IPage result = tProductCategoryService.page(page);
        List<TProductCategory>  tProductCategoryList = result.getRecords();
        return  CommonResultResponse.ok(tProductCategoryList);
    }

    /**
    * 列表
    */
    @ApiOperation(value = "列表",notes = "通用结果返回对象")
    @GetMapping("tProductCategory/list")
    public CommonResult<TProductCategory> list(){
        List<TProductCategory> tProductCategoryList = tProductCategoryService.list(new QueryWrapper<TProductCategory>());
        return  CommonResultResponse.ok(tProductCategoryList);
    }

    /**
    *  id删除
    */
    @ApiOperation(value = "id删除",notes = "通用结果返回对象")
    @PostMapping("tProductCategory/delete")
    public CommonResult<Boolean> delete(Integer id){
        Boolean success = tProductCategoryService.removeById(id);
        return CommonResultResponse.ok(success);
    }

    /**
    *  id查询
    */
    @ApiOperation(value = "id查询",notes = "通用结果返回对象")
    @GetMapping("tProductCategory/findById")
    public CommonResult<TProductCategory> findById(Integer id){
        TProductCategory tProductCategory = tProductCategoryService.getById(id);
        return CommonResultResponse.ok(tProductCategory);
    }

     /**
      *  新增
      */
     @ApiOperation(value = "新增",notes = "通用结果返回对象")
     @PostMapping("tProductCategory/add")
     public CommonResult<Boolean> add(TProductCategory tProductCategory){
        Boolean success = tProductCategoryService.save(tProductCategory);
        return CommonResultResponse.ok(success);
     }
}
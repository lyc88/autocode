package com.example.demo.test.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.test.entity.AntCategory;
import com.example.demo.test.service.AntCategoryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import com.example.demo.bean.CommonResult;
import com.example.demo.bean.CommonResultResponse;
import java.util.List;
/**
* 支付宝门店类目
* @author lyc
* @date 2020-12-24 14:02:36
*/
@Api(value = "支付宝门店类目",tags={"支付宝门店类目操作接口"})
@RestController
public class AntCategoryController{

    @Autowired
    private AntCategoryService antCategoryService;

    /**
    * 分页查询 size 页大小 current 当前页
    */
    @ApiOperation(value = "分页",notes = "通用结果返回对象")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "size", value = "页大小 默认10", defaultValue = "10"),
    @ApiImplicitParam(name = "current", value = "当前页 默认1", defaultValue = "1")
    })
    @GetMapping("antCategory/page")
    public CommonResult<AntCategory> page(@RequestParam(name = "size",defaultValue = "10") Integer size,
                                                @RequestParam(name = "current",defaultValue = "1") Integer current){
        Page page = new Page(current,size);
        IPage result = antCategoryService.page(page);
        List<AntCategory>  antCategoryList = result.getRecords();
        return  CommonResultResponse.ok(antCategoryList);
    }

    /**
    * 列表
    */
    @ApiOperation(value = "列表",notes = "通用结果返回对象")
    @GetMapping("antCategory/list")
    public CommonResult<AntCategory> list(){
        List<AntCategory> antCategoryList = antCategoryService.list(new QueryWrapper<AntCategory>());
        return  CommonResultResponse.ok(antCategoryList);
    }

    /**
    *  id删除
    */
    @ApiOperation(value = "id删除",notes = "通用结果返回对象")
    @PostMapping("antCategory/delete")
    public CommonResult<Boolean> delete(Integer id){
        Boolean success = antCategoryService.removeById(id);
        return CommonResultResponse.ok(success);
    }

    /**
    *  id查询
    */
    @ApiOperation(value = "id查询",notes = "通用结果返回对象")
    @GetMapping("antCategory/findById")
    public CommonResult<AntCategory> findById(Integer id){
        AntCategory antCategory = antCategoryService.getById(id);
        return CommonResultResponse.ok(antCategory);
    }

     /**
      *  新增
      */
     @ApiOperation(value = "新增",notes = "通用结果返回对象")
     @PostMapping("antCategory/add")
     public CommonResult<Boolean> add(AntCategory antCategory){
        Boolean success = antCategoryService.save(antCategory);
        return CommonResultResponse.ok(success);
     }
}
package com.example.demo.test.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.test.entity.TUnit;
import com.example.demo.test.service.TUnitService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import com.example.demo.bean.CommonResult;
import com.example.demo.bean.CommonResultResponse;
import java.util.List;
/**
* 产品单位
* @author lyc
* @date 2020-03-26 18:09:39
*/
@Api(value = "产品单位",tags={"产品单位操作接口"})
@RestController
public class TUnitController{

    @Autowired
    private TUnitService tUnitService;

    /**
    * 分页查询 size 页大小 current 当前页
    */
    @ApiOperation(value = "分页",notes = "通用结果返回对象")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "size", value = "页大小 默认10", defaultValue = "10"),
    @ApiImplicitParam(name = "current", value = "当前页 默认1", defaultValue = "1")
    })
    @GetMapping("tUnit/page")
    public CommonResult<TUnit> page(@RequestParam(name = "size",defaultValue = "10") Integer size,
                                                @RequestParam(name = "current",defaultValue = "1") Integer current){
        Page page = new Page(current,size);
        IPage result = tUnitService.page(page);
        List<TUnit>  tUnitList = result.getRecords();
        return  CommonResultResponse.ok(tUnitList);
    }

    /**
    * 列表
    */
    @ApiOperation(value = "列表",notes = "通用结果返回对象")
    @GetMapping("tUnit/list")
    public CommonResult<TUnit> list(){
        List<TUnit> tUnitList = tUnitService.list(new QueryWrapper<TUnit>());
        return  CommonResultResponse.ok(tUnitList);
    }

    /**
    *  id删除
    */
    @ApiOperation(value = "id删除",notes = "通用结果返回对象")
    @PostMapping("tUnit/delete")
    public CommonResult<Boolean> delete(Integer id){
        Boolean success = tUnitService.removeById(id);
        return CommonResultResponse.ok(success);
    }

    /**
    *  id查询
    */
    @ApiOperation(value = "id查询",notes = "通用结果返回对象")
    @GetMapping("tUnit/findById")
    public CommonResult<TUnit> findById(Integer id){
        TUnit tUnit = tUnitService.getById(id);
        return CommonResultResponse.ok(tUnit);
    }

     /**
      *  新增
      */
     @ApiOperation(value = "新增",notes = "通用结果返回对象")
     @PostMapping("tUnit/add")
     public CommonResult<Boolean> add(TUnit tUnit){
        Boolean success = tUnitService.save(tUnit);
        return CommonResultResponse.ok(success);
     }
}
package com.example.demo.test.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.test.entity.TGoods;
import com.example.demo.test.service.TGoodsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import com.example.demo.bean.CommonResult;
import com.example.demo.bean.CommonResultResponse;
import java.util.List;
/**
* 商品表
* @author lyc
* @date 2020-03-26 18:07:48
*/
@Api(value = "商品表",tags={"商品表操作接口"})
@RestController
public class TGoodsController{

    @Autowired
    private TGoodsService tGoodsService;

    /**
    * 分页查询 size 页大小 current 当前页
    */
    @ApiOperation(value = "分页",notes = "通用结果返回对象")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "size", value = "页大小 默认10", defaultValue = "10"),
    @ApiImplicitParam(name = "current", value = "当前页 默认1", defaultValue = "1")
    })
    @GetMapping("tGoods/page")
    public CommonResult<TGoods> page(@RequestParam(name = "size",defaultValue = "10") Integer size,
                                                @RequestParam(name = "current",defaultValue = "1") Integer current){
        Page page = new Page(current,size);
        IPage result = tGoodsService.page(page);
        List<TGoods>  tGoodsList = result.getRecords();
        return  CommonResultResponse.ok(tGoodsList);
    }

    /**
    * 列表
    */
    @ApiOperation(value = "列表",notes = "通用结果返回对象")
    @GetMapping("tGoods/list")
    public CommonResult<TGoods> list(){
        List<TGoods> tGoodsList = tGoodsService.list(new QueryWrapper<TGoods>());
        return  CommonResultResponse.ok(tGoodsList);
    }

    /**
    *  id删除
    */
    @ApiOperation(value = "id删除",notes = "通用结果返回对象")
    @PostMapping("tGoods/delete")
    public CommonResult<Boolean> delete(Integer id){
        Boolean success = tGoodsService.removeById(id);
        return CommonResultResponse.ok(success);
    }

    /**
    *  id查询
    */
    @ApiOperation(value = "id查询",notes = "通用结果返回对象")
    @GetMapping("tGoods/findById")
    public CommonResult<TGoods> findById(Integer id){
        TGoods tGoods = tGoodsService.getById(id);
        return CommonResultResponse.ok(tGoods);
    }

     /**
      *  新增
      */
     @ApiOperation(value = "新增",notes = "通用结果返回对象")
     @PostMapping("tGoods/add")
     public CommonResult<Boolean> add(TGoods tGoods){
        Boolean success = tGoodsService.save(tGoods);
        return CommonResultResponse.ok(success);
     }
}
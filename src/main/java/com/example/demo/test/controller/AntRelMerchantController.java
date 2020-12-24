package com.example.demo.test.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.test.entity.AntRelMerchant;
import com.example.demo.test.service.AntRelMerchantService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import com.example.demo.bean.CommonResult;
import com.example.demo.bean.CommonResultResponse;
import java.util.List;
/**
* 蚂蚁门店 传贝门店关联
* @author lyc
* @date 2020-12-24 14:04:14
*/
@Api(value = "蚂蚁门店 传贝门店关联",tags={"蚂蚁门店 传贝门店关联操作接口"})
@RestController
public class AntRelMerchantController{

    @Autowired
    private AntRelMerchantService antRelMerchantService;

    /**
    * 分页查询 size 页大小 current 当前页
    */
    @ApiOperation(value = "分页",notes = "通用结果返回对象")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "size", value = "页大小 默认10", defaultValue = "10"),
    @ApiImplicitParam(name = "current", value = "当前页 默认1", defaultValue = "1")
    })
    @GetMapping("antRelMerchant/page")
    public CommonResult<AntRelMerchant> page(@RequestParam(name = "size",defaultValue = "10") Integer size,
                                                @RequestParam(name = "current",defaultValue = "1") Integer current){
        Page page = new Page(current,size);
        IPage result = antRelMerchantService.page(page);
        List<AntRelMerchant>  antRelMerchantList = result.getRecords();
        return  CommonResultResponse.ok(antRelMerchantList);
    }

    /**
    * 列表
    */
    @ApiOperation(value = "列表",notes = "通用结果返回对象")
    @GetMapping("antRelMerchant/list")
    public CommonResult<AntRelMerchant> list(){
        List<AntRelMerchant> antRelMerchantList = antRelMerchantService.list(new QueryWrapper<AntRelMerchant>());
        return  CommonResultResponse.ok(antRelMerchantList);
    }

    /**
    *  id删除
    */
    @ApiOperation(value = "id删除",notes = "通用结果返回对象")
    @PostMapping("antRelMerchant/delete")
    public CommonResult<Boolean> delete(Integer id){
        Boolean success = antRelMerchantService.removeById(id);
        return CommonResultResponse.ok(success);
    }

    /**
    *  id查询
    */
    @ApiOperation(value = "id查询",notes = "通用结果返回对象")
    @GetMapping("antRelMerchant/findById")
    public CommonResult<AntRelMerchant> findById(Integer id){
        AntRelMerchant antRelMerchant = antRelMerchantService.getById(id);
        return CommonResultResponse.ok(antRelMerchant);
    }

     /**
      *  新增
      */
     @ApiOperation(value = "新增",notes = "通用结果返回对象")
     @PostMapping("antRelMerchant/add")
     public CommonResult<Boolean> add(AntRelMerchant antRelMerchant){
        Boolean success = antRelMerchantService.save(antRelMerchant);
        return CommonResultResponse.ok(success);
     }
}
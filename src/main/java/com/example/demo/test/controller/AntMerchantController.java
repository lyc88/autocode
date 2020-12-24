package com.example.demo.test.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.test.entity.AntMerchant;
import com.example.demo.test.service.AntMerchantService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import com.example.demo.bean.CommonResult;
import com.example.demo.bean.CommonResultResponse;
import java.util.List;
/**
* 蚂蚁 门店
* @author lyc
* @date 2020-12-24 14:03:06
*/
@Api(value = "蚂蚁 门店",tags={"蚂蚁 门店操作接口"})
@RestController
public class AntMerchantController{

    @Autowired
    private AntMerchantService antMerchantService;

    /**
    * 分页查询 size 页大小 current 当前页
    */
    @ApiOperation(value = "分页",notes = "通用结果返回对象")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "size", value = "页大小 默认10", defaultValue = "10"),
    @ApiImplicitParam(name = "current", value = "当前页 默认1", defaultValue = "1")
    })
    @GetMapping("antMerchant/page")
    public CommonResult<AntMerchant> page(@RequestParam(name = "size",defaultValue = "10") Integer size,
                                                @RequestParam(name = "current",defaultValue = "1") Integer current){
        Page page = new Page(current,size);
        IPage result = antMerchantService.page(page);
        List<AntMerchant>  antMerchantList = result.getRecords();
        return  CommonResultResponse.ok(antMerchantList);
    }

    /**
    * 列表
    */
    @ApiOperation(value = "列表",notes = "通用结果返回对象")
    @GetMapping("antMerchant/list")
    public CommonResult<AntMerchant> list(){
        List<AntMerchant> antMerchantList = antMerchantService.list(new QueryWrapper<AntMerchant>());
        return  CommonResultResponse.ok(antMerchantList);
    }

    /**
    *  id删除
    */
    @ApiOperation(value = "id删除",notes = "通用结果返回对象")
    @PostMapping("antMerchant/delete")
    public CommonResult<Boolean> delete(Integer id){
        Boolean success = antMerchantService.removeById(id);
        return CommonResultResponse.ok(success);
    }

    /**
    *  id查询
    */
    @ApiOperation(value = "id查询",notes = "通用结果返回对象")
    @GetMapping("antMerchant/findById")
    public CommonResult<AntMerchant> findById(Integer id){
        AntMerchant antMerchant = antMerchantService.getById(id);
        return CommonResultResponse.ok(antMerchant);
    }

     /**
      *  新增
      */
     @ApiOperation(value = "新增",notes = "通用结果返回对象")
     @PostMapping("antMerchant/add")
     public CommonResult<Boolean> add(AntMerchant antMerchant){
        Boolean success = antMerchantService.save(antMerchant);
        return CommonResultResponse.ok(success);
     }
}
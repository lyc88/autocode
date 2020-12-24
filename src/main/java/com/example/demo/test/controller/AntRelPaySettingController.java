package com.example.demo.test.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.test.entity.AntRelPaySetting;
import com.example.demo.test.service.AntRelPaySettingService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import com.example.demo.bean.CommonResult;
import com.example.demo.bean.CommonResultResponse;
import java.util.List;
/**
* 蚂蚁门店 支付配置关联
* @author lyc
* @date 2020-12-24 14:04:43
*/
@Api(value = "蚂蚁门店 支付配置关联",tags={"蚂蚁门店 支付配置关联操作接口"})
@RestController
public class AntRelPaySettingController{

    @Autowired
    private AntRelPaySettingService antRelPaySettingService;

    /**
    * 分页查询 size 页大小 current 当前页
    */
    @ApiOperation(value = "分页",notes = "通用结果返回对象")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "size", value = "页大小 默认10", defaultValue = "10"),
    @ApiImplicitParam(name = "current", value = "当前页 默认1", defaultValue = "1")
    })
    @GetMapping("antRelPaySetting/page")
    public CommonResult<AntRelPaySetting> page(@RequestParam(name = "size",defaultValue = "10") Integer size,
                                                @RequestParam(name = "current",defaultValue = "1") Integer current){
        Page page = new Page(current,size);
        IPage result = antRelPaySettingService.page(page);
        List<AntRelPaySetting>  antRelPaySettingList = result.getRecords();
        return  CommonResultResponse.ok(antRelPaySettingList);
    }

    /**
    * 列表
    */
    @ApiOperation(value = "列表",notes = "通用结果返回对象")
    @GetMapping("antRelPaySetting/list")
    public CommonResult<AntRelPaySetting> list(){
        List<AntRelPaySetting> antRelPaySettingList = antRelPaySettingService.list(new QueryWrapper<AntRelPaySetting>());
        return  CommonResultResponse.ok(antRelPaySettingList);
    }

    /**
    *  id删除
    */
    @ApiOperation(value = "id删除",notes = "通用结果返回对象")
    @PostMapping("antRelPaySetting/delete")
    public CommonResult<Boolean> delete(Integer id){
        Boolean success = antRelPaySettingService.removeById(id);
        return CommonResultResponse.ok(success);
    }

    /**
    *  id查询
    */
    @ApiOperation(value = "id查询",notes = "通用结果返回对象")
    @GetMapping("antRelPaySetting/findById")
    public CommonResult<AntRelPaySetting> findById(Integer id){
        AntRelPaySetting antRelPaySetting = antRelPaySettingService.getById(id);
        return CommonResultResponse.ok(antRelPaySetting);
    }

     /**
      *  新增
      */
     @ApiOperation(value = "新增",notes = "通用结果返回对象")
     @PostMapping("antRelPaySetting/add")
     public CommonResult<Boolean> add(AntRelPaySetting antRelPaySetting){
        Boolean success = antRelPaySettingService.save(antRelPaySetting);
        return CommonResultResponse.ok(success);
     }
}
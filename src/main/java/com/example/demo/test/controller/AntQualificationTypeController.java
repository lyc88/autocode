package com.example.demo.test.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.test.entity.AntQualificationType;
import com.example.demo.test.service.AntQualificationTypeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import com.example.demo.bean.CommonResult;
import com.example.demo.bean.CommonResultResponse;
import java.util.List;
/**
* 蚂蚁行业资质类型
* @author lyc
* @date 2020-12-24 14:03:36
*/
@Api(value = "蚂蚁行业资质类型",tags={"蚂蚁行业资质类型操作接口"})
@RestController
public class AntQualificationTypeController{

    @Autowired
    private AntQualificationTypeService antQualificationTypeService;

    /**
    * 分页查询 size 页大小 current 当前页
    */
    @ApiOperation(value = "分页",notes = "通用结果返回对象")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "size", value = "页大小 默认10", defaultValue = "10"),
    @ApiImplicitParam(name = "current", value = "当前页 默认1", defaultValue = "1")
    })
    @GetMapping("antQualificationType/page")
    public CommonResult<AntQualificationType> page(@RequestParam(name = "size",defaultValue = "10") Integer size,
                                                @RequestParam(name = "current",defaultValue = "1") Integer current){
        Page page = new Page(current,size);
        IPage result = antQualificationTypeService.page(page);
        List<AntQualificationType>  antQualificationTypeList = result.getRecords();
        return  CommonResultResponse.ok(antQualificationTypeList);
    }

    /**
    * 列表
    */
    @ApiOperation(value = "列表",notes = "通用结果返回对象")
    @GetMapping("antQualificationType/list")
    public CommonResult<AntQualificationType> list(){
        List<AntQualificationType> antQualificationTypeList = antQualificationTypeService.list(new QueryWrapper<AntQualificationType>());
        return  CommonResultResponse.ok(antQualificationTypeList);
    }

    /**
    *  id删除
    */
    @ApiOperation(value = "id删除",notes = "通用结果返回对象")
    @PostMapping("antQualificationType/delete")
    public CommonResult<Boolean> delete(Integer id){
        Boolean success = antQualificationTypeService.removeById(id);
        return CommonResultResponse.ok(success);
    }

    /**
    *  id查询
    */
    @ApiOperation(value = "id查询",notes = "通用结果返回对象")
    @GetMapping("antQualificationType/findById")
    public CommonResult<AntQualificationType> findById(Integer id){
        AntQualificationType antQualificationType = antQualificationTypeService.getById(id);
        return CommonResultResponse.ok(antQualificationType);
    }

     /**
      *  新增
      */
     @ApiOperation(value = "新增",notes = "通用结果返回对象")
     @PostMapping("antQualificationType/add")
     public CommonResult<Boolean> add(AntQualificationType antQualificationType){
        Boolean success = antQualificationTypeService.save(antQualificationType);
        return CommonResultResponse.ok(success);
     }
}
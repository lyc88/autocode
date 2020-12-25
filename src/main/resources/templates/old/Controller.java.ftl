package ${package}.${moduleName}.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import ${package}.${moduleName}.entity.${table.className};
import ${package}.${moduleName}.service.${table.className}Service;
<#if swaggerEnable==true>
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
</#if>
import ${package}.bean.CommonResult;
import ${package}.bean.CommonResultResponse;
import java.util.List;
/**
* ${table.tableComment}
* @author ${author}
* @date ${datetime}
*/
<#if swaggerEnable==true>
@Api(value = "${table.tableComment}",tags={"${table.tableComment}操作接口"})
</#if>
@RestController
public class ${table.className}Controller{

    @Autowired
    private ${table.className}Service ${table.attrName}Service;

    /**
    * 分页查询 size 页大小 current 当前页
    */
    <#if swaggerEnable==true>
    @ApiOperation(value = "分页",notes = "通用结果返回对象")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "size", value = "页大小 默认10", defaultValue = "10"),
    @ApiImplicitParam(name = "current", value = "当前页 默认1", defaultValue = "1")
    })
    </#if>
    @GetMapping("${table.attrName}/page")
    public CommonResult<${table.className}> page(@RequestParam(name = "size",defaultValue = "10") Integer size,
                                                @RequestParam(name = "current",defaultValue = "1") Integer current){
        Page page = new Page(current,size);
        IPage result = ${table.attrName}Service.page(page);
        List<${table.className}>  ${table.attrName}List = result.getRecords();
        return  CommonResultResponse.ok(${table.attrName}List);
    }

    /**
    * 列表
    */
    <#if swaggerEnable==true>
    @ApiOperation(value = "列表",notes = "通用结果返回对象")
    </#if>
    @GetMapping("${table.attrName}/list")
    public CommonResult<${table.className}> list(){
        List<${table.className}> ${table.attrName}List = ${table.attrName}Service.list(new QueryWrapper<${table.className}>());
        return  CommonResultResponse.ok(${table.attrName}List);
    }

    /**
    *  id删除
    */
    <#if swaggerEnable==true>
    @ApiOperation(value = "id删除",notes = "通用结果返回对象")
    </#if>
    @PostMapping("${table.attrName}/delete")
    public CommonResult<Boolean> delete(Integer id){
        Boolean success = ${table.attrName}Service.removeById(id);
        return CommonResultResponse.ok(success);
    }

    /**
    *  id查询
    */
    <#if swaggerEnable==true>
    @ApiOperation(value = "id查询",notes = "通用结果返回对象")
    </#if>
    @GetMapping("${table.attrName}/findById")
    public CommonResult<${table.className}> findById(Integer id){
        ${table.className} ${table.attrName} = ${table.attrName}Service.getById(id);
        return CommonResultResponse.ok(${table.attrName});
    }

     /**
      *  新增
      */
    <#if swaggerEnable==true>
     @ApiOperation(value = "新增",notes = "通用结果返回对象")
    </#if>
     @PostMapping("${table.attrName}/add")
     public CommonResult<Boolean> add(${table.className} ${table.attrName}){
        Boolean success = ${table.attrName}Service.save(${table.attrName});
        return CommonResultResponse.ok(success);
     }
}
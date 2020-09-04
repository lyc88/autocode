package ${package}.${moduleName}.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.bean.PageVO;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.bean.Result;
import com.example.demo.test.entity.*;
import ${package}.${moduleName}.entity.${table.className}DO;
import ${package}.${moduleName}.service.impl.${table.className}Service;
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
@Api(tags={"${table.tableComment}操作接口"})
</#if>
@RestController
public class ${table.className}Controller{

    @Autowired
    private ${table.className}Service ${table.attrName}Service;

    /**
    *  ${table.tableComment} 分页查询
    */
    @ApiOperation("${table.tableComment}分页列表")
    @GetMapping("/page/${table.attrName}")
    public Result<PageVO<${table.className}DO>> page${table.className}(${table.className}QueryDTO ${table.attrName}QueryDTO){
        PageVO page = ${table.attrName}Service.page${table.className}(${table.attrName}QueryDTO);
        return Result.ok(page);
    }



    /**
    *  id删除
    */
    @ApiOperation(value = "${table.tableComment}id删除")
    @DeleteMapping("/delete/${table.attrName}ById")
    public Result delete(${table.className}DeleteDTO ${table.attrName}DeleteDTO ){
        boolean result = ${table.attrName}Service.delete${table.className}(${table.attrName}DeleteDTO);
        return Result.ok(result);
    }


    /**
    *  ${table.tableComment}更新
    */
    @ApiOperation(value = "${table.tableComment}更新")
    @PutMapping("/update/${table.attrName}")
    public Result update(${table.className}UpdateDTO ${table.attrName}UpdateDTO ){
        boolean result = ${table.attrName}Service.update${table.className}(${table.attrName}UpdateDTO);
        return Result.ok(result);
    }

    /**
    *  ${table.tableComment}添加
    */
    @ApiOperation(value = "${table.tableComment}添加")
    @PostMapping("/add/${table.attrName}")
    public Result add(${table.className}AddDTO ${table.attrName}AddDTO ){
        boolean result = ${table.attrName}Service.add${table.className}(${table.attrName}AddDTO);
        return Result.ok(result);
    }
}
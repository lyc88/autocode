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
    @GetMapping("/v1/page/${table.attrName}")
    public Result<Page<${table.className}>> page${table.className}(${table.className}QueryReqVO ${table.className}QueryReqVO){

        return new Result(RETURN_CODE_100200);
    }



    /**
    *  id删除
    */
    @ApiOperation(value = "id删除")
    @DeleteMapping("/v1/delete${table.attrName}ById")
    public Result delete(${table.className}DeleteVO ${table.className}DeleteVO ){
        Boolean success = ${table.attrName}Service.removeById(id);
        return new Result(RETURN_CODE_100200);
    }


}
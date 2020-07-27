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
    @ApiVersion(API.V1)
    @GetMapping("/page/${table.attrName}")
    public Result<ExternalPage<${table.className}DO>> page${table.className}(${table.className}QueryReqVO ${table.attrName}QueryReqVO){

        return new Result(RETURN_CODE_100200);
    }



    /**
    *  id删除
    */
    @ApiOperation(value = "id删除")
    @ApiVersion(API.V1)
    @DeleteMapping("/delete/${table.className}ById")
    public Result delete(${table.className}DeleteReqVO ${table.attrName}DeleteReqVO ){

        return new Result(RETURN_CODE_100200);
    }


    /**
    *  ${table.tableComment}更新
    */
    @ApiOperation(value = "${table.className}更新")
    @ApiVersion(API.V1)
    @PutMapping("/update/${table.className}")
    public Result update(${table.className}DeleteReqVO ${table.attrName}DeleteReqVO ){

        return new Result(RETURN_CODE_100200);
    }

    /**
    *  ${table.tableComment}添加
    */
    @ApiOperation(value = "${table.className}添加")
    @ApiVersion(API.V1)
    @PostMapping("/add/${table.className}ById")
    public Result add(${table.className}DeleteReqVO ${table.attrName}DeleteReqVO ){

        return new Result(RETURN_CODE_100200);
    }
}
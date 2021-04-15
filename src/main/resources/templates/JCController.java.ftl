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
import ${package}.${moduleName}.entity.${table.className}AddParam;
import ${package}.${moduleName}.entity.${table.className}DeleteParam;
import ${package}.${moduleName}.entity.${table.className}UpdateParam;
import ${package}.${moduleName}.entity.${table.className}QueryParam;
import ${package}.${moduleName}.service.${table.className}Service;
import io.swagger.annotations.ApiOperation;

import ${package}.bean.ResultVO;
import ${package}.bean.CommonPage;
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
    public ResultVO<CommonPage<${table.className}>> page${table.className}(${table.className}QueryParam ${table.attrName}QueryParam){
        CommonPage page = ${table.attrName}Service.page(${table.attrName}QueryParam);
        return  ResultVO.ok(page);
    }



    /**
    *  id删除
    */
    @ApiOperation(value = "id删除")
    @PostMapping("/delete/${table.className}ById")
    public ResultVO delete(${table.className}DeleteParam  ${table.attrName}DeleteParam){
        Boolean success = ${table.attrName}Service.delete(${table.attrName}DeleteParam);
        return  ResultVO.ok(success);
    }


    /**
    *  ${table.tableComment}更新
    */
    @ApiOperation(value = "${table.tableComment}更新")
    @PostMapping("/update/${table.className}")
    public ResultVO update(${table.className}UpdateParam  ${table.attrName}UpdateParam){
        Boolean success = ${table.attrName}Service.update(${table.attrName}UpdateParam);
        return  ResultVO.ok(success);
    }

    /**
    *  ${table.tableComment}添加
    */
    @ApiOperation(value = "${table.tableComment}添加")
    @PostMapping("/add/${table.className}")
    public ResultVO add(${table.className}AddParam  ${table.attrName}AddParam){
        Boolean success = ${table.attrName}Service.add(${table.attrName}AddParam);
        return  ResultVO.ok(success);
    }
}
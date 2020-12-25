package ${package}.${moduleName}.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import ${package}.${moduleName}.entity.${table.className};
import ${package}.${moduleName}.service.${table.className}Service;
import com.yi.chuan.common.model.response.PageListForYAPI;
import java.util.List;
import com.yi.chuan.common.core.Result
import org.springframework.validation.annotation.Validated;
/**
* ${table.tableComment}
* @author ${author}
* @date ${datetime}
*/
@RestController
public class ${table.className}Controller{

    @Autowired
    private ${table.className}Service ${table.attrName}Service;

    /**
    * 分页查询 size 页大小 page 当前页
    */
    @OperateLog(description = "分页${table.tableComment} 列表")
    @GetMapping("${table.attrName}/page")
    public Result<PageListForYAPI<${table.className}PO>> page(${table.className}ListRequest request){
        PageListForYAPI<${table.className}> page${table.className} = ${table.attrName}Service.page(request);
        return  ResultGenerator.genSuccessResult(page${table.className});
    }



    /**
    *  删除
    */
    @OperateLog(description = "${table.tableComment} 删除")
    @PostMapping("${table.attrName}/delete")
    public Result<Boolean> delete(@Validated ${table.className}DeleteRequest request){
        Boolean result = ${table.attrName}Service.delete(request);
        return ResultGenerator.genSuccessResult(result);
    }



    /**
    *  新增
    */
    @OperateLog(description = "${table.tableComment} 新增")
    @PostMapping("${table.attrName}/add")
    public Result<Boolean> add(@Validated ${table.className}AddRequest request){
        Boolean result = ${table.attrName}Service.add(request);
        return ResultGenerator.genSuccessResult(result);
    }

    /**
      *  修改
    */
    @OperateLog(description = "${table.tableComment} 修改")
    @PostMapping("${table.attrName}/edit")
    public Result<Boolean> edit(@Validated ${table.className}EditRequest request){
        Boolean result = ${table.attrName}Service.edit(request);
        return ResultGenerator.genSuccessResult(result);
    }
}
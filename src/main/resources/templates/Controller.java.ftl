package ${package}.${moduleName}.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import ${package}.${moduleName}.entity.${table.className};
import ${package}.${moduleName}.service.${table.className}Service;
import com.example.demo.bean.CommonResult;
import com.example.demo.bean.CommonResultResponse;
import java.util.List;
/**
* ${table.tableComment}
*
* @author ${author}
* @date ${datetime}
*/
@RestController
public class ${table.className}Controller{

    @Autowired
    private ${table.className}Service ${table.attrName}Service;

    /**
    * 列表
    */
    @RequestMapping("${table.attrName}/list")
    public CommonResult<${table.className}> list(){
        List<${table.className}> ${table.attrName}s = ${table.attrName}Service.list(new QueryWrapper<${table.className}>());
        return new CommonResultResponse<List<${table.className}>>().ok(${table.attrName}s);
    }

    /**
    *  id删除
    */
    @RequestMapping("${table.attrName}/delete")
    public CommonResult<${table.className}> delete(Integer id){
        Boolean success = ${table.attrName}Service.removeById(id);
        return new CommonResultResponse<Boolean>().ok(success);
    }

    /**
    *  id查询
    */
    @RequestMapping("${table.attrName}/findById")
    public CommonResult<${table.className}> findById(Integer id){
        ${table.className} ${table.attrName} = ${table.attrName}Service.getById(id);
        return new CommonResultResponse<${table.className}>().ok(${table.attrName});
    }

     /**
      *  新增
      */
     @RequestMapping("${table.attrName}/add")
     public CommonResult<${table.className}> add(${table.className} ${table.attrName}){
        Boolean success = ${table.attrName}Service.save(${table.attrName});
        return new CommonResultResponse<Boolean>().ok(success);
     }
}
package ${serviceImplPackage};
import java.util.List;
import org.springframework.beans.BeanUtils;
import com.github.pagehelper.PageHelper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import ${entityPackage}.${table.className};
import ${servicePackage}.${table.className}Service;
import ${daoPackage}.${table.className}Mapper;
import ${entityAddPackage}.${table.className}AddParam;
import ${entityDeletePackage}.${table.className}DeleteParam;
import ${entityUpdatePackage}.${table.className}UpdateParam;
import ${entityQueryPackage}.${table.className}QueryParam;

import ${commonPackage}.CommonPage;
/**
* ${table.tableComment}
*
* @author ${author}
* @date ${datetime}
*/
@Service
public class ${table.className}ServiceImpl extends ServiceImpl<${table.className}Mapper,${table.className}> implements  ${table.className}Service{


    public CommonPage<${table.className}> page(${table.className}QueryParam ${table.attrName}QueryParam){
        Integer pageNum = ${table.attrName}QueryParam.getPageNum();
        Integer pageSize = ${table.attrName}QueryParam.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        LambdaQueryWrapper<${table.className}> lambda = new QueryWrapper<${table.className}>().lambda();
        queryCondition(lambda,${table.attrName}QueryParam);
        List<${table.className}> ${table.attrName}List = list(lambda);
        CommonPage<${table.className}> ${table.attrName}CommonPage = CommonPage.restPage(${table.attrName}List);
        return ${table.attrName}CommonPage;
    }

    private void queryCondition(LambdaQueryWrapper<${table.className}> lambda,${table.className}QueryParam ${table.attrName}QueryParam){

        lambda.orderByDesc(${table.className}::get${table.pkAttrKey});
    }

    public Boolean add(${table.className}AddParam ${table.attrName}AddParam){
        ${table.className} ${table.attrName} = new ${table.className}();
        BeanUtils.copyProperties(${table.attrName}AddParam,${table.attrName});
        save(${table.attrName});
        return true;
    }

    public Boolean update(${table.className}UpdateParam ${table.attrName}UpdateParam){
        ${table.className} ${table.attrName} = new ${table.className}();
        BeanUtils.copyProperties(${table.attrName}UpdateParam,${table.attrName});
        updateById(${table.attrName});
        return true;
    }

    public Boolean delete(${table.className}DeleteParam ${table.attrName}DeleteParam){
        removeById(${table.attrName}DeleteParam.getId());
        return true;
    }
}
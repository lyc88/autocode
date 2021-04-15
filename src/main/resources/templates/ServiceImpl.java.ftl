package ${package}.${moduleName}.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import ${package}.${moduleName}.entity.${table.className};
import ${package}.${moduleName}.service.${table.className}Service;
import ${package}.${moduleName}.mapper.${table.className}Mapper;
import ${package}.${moduleName}.entity.${table.className}AddParam;
import ${package}.${moduleName}.entity.${table.className}DeleteParam;
import ${package}.${moduleName}.entity.${table.className}UpdateParam;
import ${package}.${moduleName}.entity.${table.className}QueryParam;
import ${package}.bean.CommonPage;
/**
* ${table.tableComment}
*
* @author ${author}
* @date ${datetime}
*/
@Service
public class ${table.className}ServiceImpl extends ServiceImpl<${table.className}Mapper,${table.className}> implements  ${table.className}Service{


    public CommonPage<${table.className}> page(${table.className}QueryParam ${table.attrName}QueryParam){
        return null;
    }

    public Boolean add(${table.className}AddParam ${table.attrName}AddParam){
        return true;
    }

    public Boolean update(${table.className}UpdateParam ${table.attrName}UpdateParam){
        return true;
    }

    public Boolean delete(${table.className}DeleteParam ${table.attrName}DeleteParam){
        return true;
    }
}
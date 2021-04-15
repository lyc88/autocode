package ${package}.${moduleName}.service;

import com.baomidou.mybatisplus.extension.service.IService;

import ${package}.${moduleName}.entity.${table.className};
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

public interface ${table.className}Service extends IService<${table.className}>{

    CommonPage<${table.className}> page(${table.className}QueryParam ${table.attrName}QueryParam);

    Boolean add(${table.className}AddParam ${table.attrName}AddParam);

    Boolean update(${table.className}UpdateParam ${table.attrName}UpdateParam);

    Boolean delete(${table.className}DeleteParam ${table.attrName}DeleteParam);
}
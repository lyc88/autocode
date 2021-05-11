package ${servicePackage};

import com.baomidou.mybatisplus.extension.service.IService;

import ${entityPackage}.${table.className};
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

public interface ${table.className}Service extends IService<${table.className}>{

    CommonPage<${table.className}> page(${table.className}QueryParam ${table.attrName}QueryParam);

    Boolean add(${table.className}AddParam ${table.attrName}AddParam);

    Boolean update(${table.className}UpdateParam ${table.attrName}UpdateParam);

    Boolean delete(${table.className}DeleteParam ${table.attrName}DeleteParam);
}
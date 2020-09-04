package ${package}.${moduleName}.service.impl;

import com.jctech.framework.boot.mongodb.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import ${package}.${moduleName}.entity.${table.className};
import ${package}.${moduleName}.service.${table.className}Service;
import ${package}.${moduleName}.mapper.${table.className}Mapper;
/**
* @author ${author}
* @date ${datetime}
* @describe ${table.tableComment}${table.tableComment}
*/
@Service
public class ${table.className}Service extends BaseServiceImpl<${table.className}DO> {

    boolean add${table.className}(${table.className}AddReqVO ${table.attrName}AddDTO){
        return true;
    }

    boolean update${table.className}(${table.className}UpdateReqVO ${table.attrName}UpdateDTO){
        return true;
    }


    Page page${table.className}(${table.className}QueryReqVO ${table.attrName}QueryDTO){
        return null;
    }

    boolean delete${table.className}(${table.className}DeleteReqVO ${table.attrName}DeleteDTO){
        return true;
    }
}
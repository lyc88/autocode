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
public class ${table.className}ServiceImpl extends BaseServiceImpl<${table.className}DO> implements  ${table.className}Service{

}
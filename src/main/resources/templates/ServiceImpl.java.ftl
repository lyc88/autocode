package ${package}.${moduleName}.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import ${package}.${moduleName}.entity.${table.className};
import ${package}.${moduleName}.service.${table.className}Service;
import ${package}.${moduleName}.mapper.${table.className}Mapper;
/**
* ${table.tableComment}
*
* @author ${author}
* @date ${datetime}
*/
@Service
public class ${table.className}ServiceImpl extends ServiceImpl<${table.className}Mapper,${table.className}> implements  ${table.className}Service{

}
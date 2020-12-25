package ${package}.${moduleName}.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import ${package}.${moduleName}.entity.${table.className};
/**
* ${table.tableComment}
*
* @author ${author}
* @date ${datetime}
*/
@Mapper
public interface ${table.className}Mapper extends BaseMapper<${table.className}>{

}
package ${package}.${moduleName}.service.impl;


import org.springframework.stereotype.Service;
import com.yi.chuan.common.core.AbstractService;
import ${package}.${moduleName}.entity.${table.className}PO;
/**
* ${table.tableComment}
*
* @author ${author}
* @date ${datetime}
*/
@Service
public class ${table.className}ServiceImpl extends AbstractService<${table.className}PO> implements  ${table.className}Service{

    @Override
    public PageListForYAPI page(${table.className}ListRequest request){

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean delete(${table.className}DeleteRequest request){

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean add(${table.className}AddRequest request){

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean edit(${table.className}EditRequest request){

    }
}
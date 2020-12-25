package ${package}.${moduleName}.service;

import com.yi.chuan.common.core.Service;
import com.yi.chuan.common.model.response.PageListForYAPI;
import ${package}.${moduleName}.entity.${table.className}PO;
/**
* ${table.tableComment}
*
* @author ${author}
* @date ${datetime}
*/

public interface ${table.className}Service extends Service<${table.className}PO>{

    /**
    * ${table.tableComment} 分页
    *
    * @param request
    * @return
    */
    PageListForYAPI page(${table.className}ListRequest request);

    /**
    * ${table.tableComment} 删除
    *
    * @param request
    * @return
    */
    Boolean delete(${table.className}DeleteRequest request);

    /**
    * ${table.tableComment} 添加
    *
    * @param request
    * @return
    */
    Boolean add(${table.className}AddRequest request);

    /**
    * ${table.tableComment} 编辑
    *
    * @param request
    * @return
    */
    Boolean edit(${table.className}EditRequest request);
}
package ${package}.${moduleName}.service;

import com.jctech.framework.boot.mongodb.base.service.BaseService;

import ${package}.${moduleName}.entity.${table.className};
/**
* @author ${author}
* @date ${datetime}
* @describe ${table.tableComment}${table.tableComment}
*/

public interface ${table.className}Service extends BaseService<${table.className}DO>{
    /**
    * 添加 ${table.tableComment}
    * @param
    * @return
    */
    boolean add${table.className}(${table.className}AddReqVO ${table.attrName}AddReqVO);

    /**
    * 修改 ${table.tableComment}
    * @param
    * @return
    */
    boolean update${table.className}(${table.className}UpdateReqVO ${table.attrName}UpdateReqVO);

    /**
    * 分页 ${table.tableComment}
    * @param
    * @return
    */
    Page page${table.className}(${table.className}QueryReqVO ${table.attrName}QueryReqVO);


    /**
    * 分页 ${table.tableComment}
    * @param
    * @return
    */
    boolean delete${table.className}(${table.className}DeleteReqVO ${table.attrName}DeleteReqVO);
}
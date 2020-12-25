package ${package}.${moduleName}.entity;

import com.yi.chuan.common.model.request.base.BaseValidateRequest
import lombok.Data;

/**
* ${table.tableComment}
*
* @author ${author}
* @date ${datetime}
*/
@Data
public class ${table.className}ListRequest extends BaseValidateRequest{
<#list table.columns as column>

    /**
    * ${column.columnComment}
    */
    private ${column.attrType} ${column.attrName};

</#list>
}
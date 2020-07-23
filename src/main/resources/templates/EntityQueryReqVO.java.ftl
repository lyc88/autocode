package ${package}.${moduleName}.entity;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;
<#if bigDecimal==1>
import java.math.BigDecimal;
</#if>
import java.util.Date;



/**
* ${table.tableComment}
*
* @author ${author}
* @date ${datetime}
*/
public class ${table.className}QueryReqVO{
<#list table.columns as column>
    /**
    * ${column.columnComment}
    */
    @ApiModelProperty(value = "${column.columnComment}" <#if column.ableNull=="NO">,required = true</#if>)
    <#if column.ableNull=="NO">
        @NotNull(message = "${column.columnComment}不能为空")
    </#if>
    private ${column.attrType} ${column.attrName};

</#list>
}
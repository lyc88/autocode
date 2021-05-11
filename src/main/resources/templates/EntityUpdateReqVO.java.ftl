package ${entityUpdatePackage};
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;

<#if bigDecimal==1>
import java.math.BigDecimal;
</#if>
import java.util.Date;
import lombok.Data;

/**
* ${table.tableComment}
*
* @author ${author}
* @date ${datetime}
*/
@Data
public class ${table.className}UpdateParam{
<#list table.columns as column>
    /**
    * ${column.columnComment}
    */
    @ApiModelProperty(value = "${column.columnComment}" <#if column.ableNull=="NO">,required = true</#if>)
    private ${column.attrType} ${column.attrName};

</#list>
}
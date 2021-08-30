package ${entityDeletePackage};
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
public class ${table.className}DeleteParam{
<#list table.columns as column>

    <#if column.columnKey=="PRI">
      /**
       * ${column.columnComment}
       */
        <#if swaggerEnable==true>
       @ApiModelProperty(value = "${column.columnComment}" <#if column.ableNull=="NO">,required = true</#if>)
        </#if>
        <#if column.ableNull=="NO">
       @NotNull(message = "${column.columnComment}不能为空")
        </#if>
       private ${column.attrType} ${column.attrName};
    </#if>

</#list>
}
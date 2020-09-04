package ${package}.${moduleName}.entity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import javax.validation.constraints.NotNull;
<#if swaggerEnable==true>
import io.swagger.annotations.ApiModelProperty;
</#if>
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
@TableName("${table.tableName}")
public class ${table.className}DO{
<#list table.columns as column>
    /**
    * ${column.columnComment}
    */
    <#if column.columnKey=="PRI">
        <#if swaggerEnable==true>
    @ApiModelProperty(value = "${column.columnComment}" <#if column.ableNull=="NO">,required = true</#if>)
        </#if>
        <#if column.ableNull=="NO">
    @NotNull(message = "${column.columnComment}不能为空")
        </#if>
    @TableId
    private ${column.attrType} ${column.attrName};
    <#else >
        <#if swaggerEnable==true>
    @ApiModelProperty(value = "${column.columnComment}"<#if column.ableNull=="NO">,required = true</#if>)
        </#if>
        <#if column.ableNull=="NO">
    @NotNull(message = "${column.columnComment}不能为空")
        </#if>
    @TableField("${column.columnName}")
    private ${column.attrType} ${column.attrName};
    </#if>

</#list>
}
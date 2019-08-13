package ${package}.${moduleName}.entity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

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
public class ${table.className}{
<#list table.columns as column>
    /**
    * ${column.columnComment}
    */
    <#if column.columnKey=="PRI">
    @TableId
    private ${column.attrType} ${column.attrName};
    <#else >
    @TableField("${column.columnName}")
    private ${column.attrType} ${column.attrName};
    </#if>

</#list>
}
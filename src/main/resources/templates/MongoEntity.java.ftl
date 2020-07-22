package ${package}.${moduleName}.entity;
import com.jctech.framework.boot.fincy.entity.BaseDO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
<#if swaggerEnable==true>
import io.swagger.annotations.ApiModelProperty;
</#if>
<#if bigDecimal==1>
import java.math.BigDecimal;
</#if>
import java.util.Date;
import lombok.Data;

/**
* @author ${author}
* @date ${datetime}
* @describe ${table.tableComment}
*/
@Data
@Document(collection = "${table.tableName}")
public class ${table.className}DO extends BaseDO implements Serializable{
<#list table.columns as column>
    /**
    * ${column.columnComment}
    */
    <#if column.columnKey=="PRI">
        <#if swaggerEnable==true>
    @ApiModelProperty(value = "${column.columnComment}" <#if column.ableNull=="NO">,required = true</#if>)
        </#if>

    @Id
    @Field(value = "${column.columnName}")
    private ${column.attrType} ${column.attrName};
    <#else >
        <#if swaggerEnable==true>
    @ApiModelProperty(value = "${column.columnComment}"<#if column.ableNull=="NO">,required = true</#if>)
        </#if>

    @Field("${column.columnName}")
    private ${column.attrType} ${column.attrName};
    </#if>

</#list>
}
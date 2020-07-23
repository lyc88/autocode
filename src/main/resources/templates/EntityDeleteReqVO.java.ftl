package ${package}.${moduleName}.entity;
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
@TableName("${table.tableName}")
public class ${table.className}{
    @NotBlank(message = "${column.columnComment}不能为空")
    private String id;
}
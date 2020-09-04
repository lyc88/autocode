package ${package}.${moduleName}.entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
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
public class ${table.className}DeleteDTO{
    @NotBlank(message = "${column.columnComment}不能为空")
    private String id;
}
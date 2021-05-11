package ${entityDeletePackage};
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
public class ${table.className}DeleteParam{
    @NotBlank(message = "${column.columnComment}不能为空")
    private String id;
}
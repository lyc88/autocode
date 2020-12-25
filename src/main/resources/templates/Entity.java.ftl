package ${package}.${moduleName}.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

/**
* ${table.tableComment}
*
* @author ${author}
* @date ${datetime}
*/
@Data
@Table(name = "${table.tableName}")
public class ${table.className}PO implements Serializable {
<#list table.columns as column>
    /**
    * ${column.columnComment}
    */
    <#if column.columnKey=="PRI">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "${column.columnName}")
    private ${column.attrType} ${column.attrName};
    <#else >
    @Column(name = "${column.columnName}")
    private ${column.attrType} ${column.attrName};
    </#if>

</#list>
}
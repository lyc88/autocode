<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="${daoPackage}.${table.className}Mapper">
    <!-- 通用查询映射结果 -->
    <resultMap id="BaseResultMap" type="${entityPackage}.${table.className}">
    <#list table.columns as column>
       <#if column.columnKey=="PRI">
          <id column="${column.columnName}" property="${column.attrName}" />
       <#else >
          <result column="${column.columnName}" property="${column.attrName}" />
       </#if>
    </#list>
    </resultMap>
    <sql id="BaseColumn">
      <#list table.columns as column>${column.columnName}<#if (table.columns?size > column_index+1) >, </#if></#list>
    </sql>
</mapper>
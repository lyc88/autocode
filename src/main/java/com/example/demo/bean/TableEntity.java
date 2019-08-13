package com.example.demo.bean;

import lombok.Data;

import java.util.List;

/**
 * 表数据
 * @author lyc
 * @date 2019/8/12.
 */
@Data
public class TableEntity {
	//表的名称
	private String tableName;
	//表的备注
	private String tableComment;

	//表的列名
	private List<ColumnEntity> columns;
	//类名(第一个字母大写)，如：sys_user => SysUser
	private String className;
	// sys_user => sysUser
	private String attrName;
}

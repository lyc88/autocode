package com.example.demo.bean;

import lombok.Data;

/**
 * 列的属性
 * @author lyc
 * @date 2019/8/12.
 */
@Data
public class ColumnEntity {
	//列名
    private String columnName;
    //列名类型
    private String dataType;
    //列名备注
    private String columnComment;
    // key 主键 PRI 字符 为UNI
    private String columnKey;
    //自增 auto_increment
    private String extra;


    //属性名称(第一个字母大写)，如：user_name => UserName
    private String attrName;
    //属性类型 如： int=>Integer
    private String attrType;


}

package com.example.demo.mapper;

import com.example.demo.bean.ColumnEntity;
import com.example.demo.bean.TableEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author lyc
 * @date 2019/8/12.
 */
@Mapper
public interface MysqlMapper {

    List<Map<String, Object>> queryList(Map<String, Object> map);

    TableEntity queryTable(String tableName);

    List<ColumnEntity> queryColumns(String tableName);
}
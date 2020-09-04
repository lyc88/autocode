package ${package}.${moduleName}.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.example.demo.bean.PageVO;
import com.example.demo.test.entity.*;
import ${package}.${moduleName}.entity.${table.className}DO;
import ${package}.${moduleName}.mapper.${table.className}Mapper;
/**
* ${table.tableComment}
*
* @author ${author}
* @date ${datetime}
*/
@Service
public class ${table.className}Service extends ServiceImpl<${table.className}Mapper,${table.className}DO>{

    /**
    *  ${table.tableComment}添加
    */
    public boolean add${table.className}(${table.className}AddDTO ${table.attrName}AddDTO){
        return true;
    }

    /**
    *  ${table.tableComment}更新
    */
    public boolean update${table.className}(${table.className}UpdateDTO ${table.attrName}UpdateDTO){
        return true;
    }

    /**
    *  ${table.tableComment} 分页查询
    */
    public PageVO page${table.className}(${table.className}QueryDTO ${table.attrName}QueryDTO){
        return null;
    }

    /**
    *  id删除
    */
    public boolean delete${table.className}(${table.className}DeleteDTO ${table.attrName}DeleteDTO){
        return true;
    }
}
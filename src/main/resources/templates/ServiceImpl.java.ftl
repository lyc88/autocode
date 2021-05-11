package ${serviceImplPackage};

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import ${entityPackage}.${table.className};
import ${servicePackage}.${table.className}Service;
import ${daoPackage}.${table.className}Mapper;
import ${entityAddPackage}.${table.className}AddParam;
import ${entityDeletePackage}.${table.className}DeleteParam;
import ${entityUpdatePackage}.${table.className}UpdateParam;
import ${entityQueryPackage}.${table.className}QueryParam;

import ${commonPackage}.CommonPage;
/**
* ${table.tableComment}
*
* @author ${author}
* @date ${datetime}
*/
@Service
public class ${table.className}ServiceImpl extends ServiceImpl<${table.className}Mapper,${table.className}> implements  ${table.className}Service{


    public CommonPage<${table.className}> page(${table.className}QueryParam ${table.attrName}QueryParam){
        return null;
    }

    public Boolean add(${table.className}AddParam ${table.attrName}AddParam){
        return true;
    }

    public Boolean update(${table.className}UpdateParam ${table.attrName}UpdateParam){
        return true;
    }

    public Boolean delete(${table.className}DeleteParam ${table.attrName}DeleteParam){
        return true;
    }
}
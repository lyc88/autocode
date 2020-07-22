package com.example.demo.service;

import com.example.demo.bean.TableEntity;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.Assert;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @author lyc
 * @date 2019/10/28.
 */
@Service
public class MongoServiceImplTemplate implements CodeTemplate {

    @Autowired
    Configuration configuration;

    @Value("${parentPath:./src/main/java/}")
    private String parentPath;

    private Map data;


    public void setData(Map data) {
        this.data = data;
    }
    @Value("${packPathName:com/example/demo/test}")
    private String packPathName;

    @Value("${servicePath:/service/impl/}")
    private String serviceImplPath;


    public Map getData() {
        return null;
    }


    public Template getTemplate() {
        try {
            return configuration.getTemplate("MongoServiceImpl.java.ftl");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void outFile() {
        try {
            TableEntity table = (TableEntity) data.get("table");
            Assert.notNull(table,"表结构不能为空");
            String result = FreeMarkerTemplateUtils.processTemplateIntoString(getTemplate(),data);
            FileUtils.write(new File(parentPath+packPathName+serviceImplPath+table.getClassName()+"ServiceImpl.java"),result,"utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
package com.example.demo.service;

import com.example.demo.bean.TableEntity;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.Assert;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @author lyc
 * @date 2019/10/28.
 */
public class DaoTemplate implements CodeTemplate {

    @Autowired
    Configuration configuration;

    @Value("${mapperPath:/mapper/}")
    private String mapperPath;

    @Value("${myBatisXmlPath:/xml/}")
    private String myBatisXmlPath;

    @Value("${parentPath:./src/main/resources/mapper}")
    private String xmlParentPath;

    @Value("${parentPath:./src/main/java/}")
    private String parentPath;

    @Value("${packPathName:com/example/demo/test}")
    private String packPathName;

    @Override
    public Map getData() {
        return null;
    }

    @Override
    public Template getTemplate() {
        try {
            return configuration.getTemplate("Mapper.java.ftl");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void outFile(Template template, Map data) {
        try {
            TableEntity table = (TableEntity) data.get("table");
            Assert.notNull(table,"表结构不能为空");
            String result = FreeMarkerTemplateUtils.processTemplateIntoString(template,data);
            FileUtils.write(new File(parentPath+packPathName+mapperPath+table.getClassName()+"Mapper.java"),result,"utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
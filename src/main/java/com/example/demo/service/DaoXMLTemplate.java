package com.example.demo.service;

import com.example.demo.bean.TableEntity;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
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
 * @date 2019/10/29.
 */
@Service
public class DaoXMLTemplate implements CodeTemplate {

    @Autowired
    Configuration configuration;

    @Value("${myBatisXmlPath:/xml/}")
    private String myBatisXmlPath;

    @Value("${parentPath:./src/main/resources/mapper}")
    private String xmlParentPath;

    private Map data;

    @Autowired
    private CodeConfigConstant codeConfigConstant;

    public void setData(Map data) {
        this.data = data;
    }

    public Map getData() {
        return data;
    }

    public Template getTemplate() {
        try {
            return configuration.getTemplate("MyBatisXml.java.ftl");
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

            String daoXmlPackage = (String) data.get("daoXmlPackage");
            String module = daoXmlPackage.replace(".", "/");
            String parentPath = codeConfigConstant.getChildXmlPath();
            parentPath = parentPath.replace(".", "/");

            String rootPath = codeConfigConstant.getMapperPath();
            if(StringUtils.isBlank(rootPath)){
                rootPath = "./";
            }

            String fileName = rootPath+parentPath +"/"+ module + "/" + table.getClassName() + "Mapper.xml";
            File file = new File(fileName);
            // 不覆盖
            if(!file.exists()){
                FileUtils.write(new File(fileName),result,"utf-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
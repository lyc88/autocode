package com.example.demo.service;

import freemarker.template.Template;

import java.util.Map;

/**
 * @author lyc
 * @date 2019/10/28.
 */
public interface CodeTemplate {
    /**
     * 获取数据
     * @return
     */
    Map getData();

    /**
     * 获取模板
     * @return
     */
    Template getTemplate();

    /**
     * 渲染文件
     * @param template
     * @param data
     */
    void outFile(Template template,Map data);
}
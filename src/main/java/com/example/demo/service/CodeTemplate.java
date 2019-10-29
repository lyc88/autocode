package com.example.demo.service;

import freemarker.template.Template;

import java.util.Map;

/**
 * @author lyc
 * @date 2019/10/28.
 */
public interface CodeTemplate {

    void setData(Map data);

    void outFile();
}
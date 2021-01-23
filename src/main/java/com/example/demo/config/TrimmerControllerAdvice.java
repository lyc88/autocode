package com.example.demo.config;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author lyc
 * @date 2019/10/21.
 *
 * https://www.jianshu.com/p/a07d21baf6c3 統一異常
 */
@RestControllerAdvice
public class TrimmerControllerAdvice {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        //binder.setDisallowedFields("name");
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

}
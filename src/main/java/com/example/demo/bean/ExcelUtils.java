package com.example.demo.bean;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelWriter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * Author:   lyc
 * Date:     2020/6/15 16:27
 */
@Slf4j
public class ExcelUtils {
    /**
     * 导出
     * @param response
     * @param fileName
     * @param rows
     */
    public static void export(HttpServletResponse response, String fileName, List<Map> rows){
        Assert.isBlank(fileName,"文件名不能为空");
        ExcelWriter writer = cn.hutool.poi.excel.ExcelUtil.getWriter();
        writer.write(rows, true);
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        try {
            response.setHeader("Content-Disposition","attachment;filename="+new String(fileName.getBytes(), "ISO-8859-1")+".xlsx");
        } catch (UnsupportedEncodingException e) {
            log.error("编码格式不支持");
        }
        ServletOutputStream out= null;
        try {
            out = response.getOutputStream();
            writer.flush(out);
            writer.close();
        } catch (IOException e) {
            log.error("导出文件错误",e);
        }finally {
            IoUtil.close(out);
        }
    }

    /**
     * 导出
     * @param file
     * @return
     */
    public static List<Map<String, Object>> importExcel(MultipartFile file)  {
        ExcelReader reader = null;
        try {
            reader = cn.hutool.poi.excel.ExcelUtil.getReader(file.getInputStream());
            List<Map<String,Object>> readAll =  reader.readAll();;
            return readAll;
        } catch (IOException e) {
            log.error("导入文件错误",e);
        }
        return null;
    }
}

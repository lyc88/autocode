package com.example.demo.utils;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.io.*;

/**
 * @author: lyc
 * @date: 2020/7/28 18:17
 * @describe 下载地址 https://npm.taobao.org/dist/phantomjs/
 */
public class PhantomTools {

    private static final Logger _logger = LoggerFactory.getLogger(PhantomTools.class);

    // private static final String _tempPath = "/data/temp/phantom_";
    // private static final String _shellCommand = "/usr/local/xxx/phantomjs /usr/local/xxx/rasterize.js ";  Linux下的命令
    private static final String _tempPath = "D:/data/temp/phantom_";
    private static final String _shellCommand = "F:/phantomjs-2.1.1-windows/bin/phantomjs F:/phantomjs-2.1.1-windows/examples/rasterize.js ";

    private String _file;
    private String _size;

    /**
     * 构造截图类
     *
     * @parm hash 用于临时文件的目录唯一化
     */
    public PhantomTools(int hash) {
        _file = _tempPath + hash + ".png";
    }

    /**
     * 构造截图类
     *
     * @param size 图片的大小，如800px*600px（此时高度会裁切），或800px（此时 高度最少=宽度*9/16，高度不裁切）
     * @parm hash 用于临时文件的目录唯一化
     */
    public PhantomTools(int hash, String size) {
        this(hash);
        if (size != null)
            _size = " " + size;
    }

    /**
     * 将目标网页转为图片字节流
     *
     * @param url 目标网页地址
     * @return 字节流
     */
    public byte[] getByteImg(String url) throws IOException {
        BufferedInputStream in = null;
        ByteArrayOutputStream out = null;
        File file = null;
        byte[] ret = null;
        try {
            if (exeCmd(_shellCommand + url + " " + _file + (_size != null ? _size : ""))) {
                file = new File(_file);
                if (file.exists()) {
                    out = new ByteArrayOutputStream();
                    byte[] b = new byte[5120];
                    in = new BufferedInputStream(new FileInputStream(file));
                    int n;
                    while ((n = in.read(b, 0, 5120)) != -1) {
                        out.write(b, 0, n);
                    }
                    file.delete();
                    ret = out.toByteArray();
                }
            } else {
                ret = new byte[]{};
            }
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                _logger.error("{}",e);
            }
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                _logger.error("{}",e);
            }
            if (file != null && file.exists()) {
                file.delete();
            }
        }
        return ret;
    }

    /**
     * 执行CMD命令
     */
    private static boolean exeCmd(String commandStr) {
        BufferedReader br = null;
        try {
            Process p = Runtime.getRuntime().exec(commandStr);
            if (p.waitFor() != 0 && p.exitValue() == 1) {
                return false;
            }
        } catch (Exception e) {
            _logger.error("{}",e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    _logger.error("{}",e);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        PhantomTools phantomTools = new PhantomTools(123);
        byte[] byteImg = phantomTools.getByteImg("https://kaiwu.lagou.com/course/courseInfo.htm?courseId=356#/detail/pc?id=4177");
        FileOutputStream outputStream = new FileOutputStream(phantomTools._file);
        outputStream.write(byteImg);
        outputStream.flush();
        outputStream.close();
    }
}

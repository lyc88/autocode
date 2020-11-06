package com.example.demo.test.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.test.entity.Link;
import com.example.demo.test.service.LinkService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import com.example.demo.bean.CommonResult;
import com.example.demo.bean.CommonResultResponse;
import java.util.List;
/**
* 
* @author lyc
* @date 2020-07-20 17:51:51
*/
@Api(value = "",tags={"操作接口"})
@RestController
public class LinkController{

    @Autowired
    private LinkService linkService;

    /**
    * 分页查询 size 页大小 current 当前页
    */
    @ApiOperation(value = "分页",notes = "通用结果返回对象")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "size", value = "页大小 默认10", defaultValue = "10"),
    @ApiImplicitParam(name = "current", value = "当前页 默认1", defaultValue = "1")
    })
    @GetMapping("link/page")
    public CommonResult<Link> page(@RequestParam(name = "size",defaultValue = "10") Integer size,
                                                @RequestParam(name = "current",defaultValue = "1") Integer current){
        Page page = new Page(current,size);
        IPage result = linkService.page(page);
        List<Link>  linkList = result.getRecords();
        return  CommonResultResponse.ok(linkList);
    }

    /**
    * 列表
    */
    @ApiOperation(value = "列表",notes = "通用结果返回对象")
    @GetMapping("link/list")
    public CommonResult<List<Link>> list(){
        //List<Link> linkList = linkService.list(new QueryWrapper<Link>());
        List<String> linkList = Lists.newArrayList();
        String s = "spring boot 设置 gzip 压缩\n" +
                " \n" +
                "\n" +
                " \n" +
                "\n" +
                "为了减少数据在网络中的传输量，从而减少传输时长，增加用户体验，浏览器大都是支持Gzip压缩技术的，http的请求头 Accept-Encoding:gzip, deflate 就表示这次请求可以接受Gzip压缩后的数据，图片不要进行压缩，因为图片完全可以在项目开发中使用压缩后的图片。压缩会有一定的CPU性能损耗。\n" +
                "\n" +
                "下面介绍几种 Gzip压缩方式\n" +
                "\n" +
                "1.SpringBoot开启Gzip压缩\n" +
                "\n" +
                "\n" +
                "在application.properties中加入如下配置：\n" +
                "\n" +
                "server.compression.enabled=true\n" +
                "server.compression.mime-types=application/javascript,text/css,application/json,application/xml,text/html,text/xml,text/plain\n" +
                "\n" +
                " \n" +
                "\n" +
                "或者在application.yml 中加入如下配置：\n" +
                "\n" +
                "server:\n" +
                "  compression:\n" +
                "    enabled: true\n" +
                "    mime-types: application/javascript,text/css,application/json,application/xml,text/html,text/xml,text/plain\n" +
                "\n" +
                " \n" +
                "\n" +
                " \n" +
                "\n" +
                "压缩后文件大概有5-8倍左右的差距，能大大减少网络传输量，页面加载速度加快\n" +
                "\n" +
                " \n" +
                "\n" +
                "2.Tomcat开启Gzip压缩\n" +
                "tomcat中使用gzip需要进行配置，在server.xml中，在Connector标签中加入如下属性\n" +
                "\n" +
                "compression=\"on\"\n" +
                "compressionMinSize=\"2048\"\n" +
                "compressableMimeType=\"text/html,text/css,text/javascript\"\n" +
                "\n" +
                "\n" +
                " \n" +
                "\n" +
                "下面我们对比一下没有开启gzip压缩和开启gzip压缩的传输量\n" +
                "\n" +
                " ";
       // Link link = new Link();
       // linkList.add(link);
        linkList.add(s);
        linkList.add(s);
        linkList.add(s);
        linkList.add(s);
        return  CommonResultResponse.ok(linkList);
    }

    /**
    *  id删除
    */
    @ApiOperation(value = "id删除",notes = "通用结果返回对象")
    @PostMapping("link/delete")
    public CommonResult<Boolean> delete(Integer id){
        Boolean success = linkService.removeById(id);
        return CommonResultResponse.ok(success);
    }

    /**
    *  id查询
    */
    @ApiOperation(value = "id查询",notes = "通用结果返回对象")
    @GetMapping("link/findById")
    public CommonResult<Link> findById(Integer id){
        Link link = linkService.getById(id);
        return CommonResultResponse.ok(link);
    }

     /**
      *  新增
      */
     @ApiOperation(value = "新增",notes = "通用结果返回对象")
     @PostMapping("link/add")
     public CommonResult<Boolean> add(Link link){
        Boolean success = linkService.save(link);
        return CommonResultResponse.ok(success);
     }
}
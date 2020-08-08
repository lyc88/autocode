package com.example.demo.test.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.test.entity.Book;
import com.example.demo.test.service.BookService;
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
* @date 2020-08-08 12:57:38
*/
@Api(value = "",tags={"操作接口"})
@RestController
public class BookController{

    @Autowired
    private BookService bookService;

    /**
    * 分页查询 size 页大小 current 当前页
    */
    @ApiOperation(value = "分页",notes = "通用结果返回对象")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "size", value = "页大小 默认10", defaultValue = "10"),
    @ApiImplicitParam(name = "current", value = "当前页 默认1", defaultValue = "1")
    })
    @GetMapping("book/page")
    public CommonResult<Book> page(@RequestParam(name = "size",defaultValue = "10") Integer size,
                                                @RequestParam(name = "current",defaultValue = "1") Integer current){
        Page page = new Page(current,size);
        IPage result = bookService.page(page);
        List<Book>  bookList = result.getRecords();
        return  CommonResultResponse.ok(bookList);
    }

    /**
    * 列表
    */
    @ApiOperation(value = "列表",notes = "通用结果返回对象")
    @GetMapping("book/list")
    public CommonResult<Book> list(){
        List<Book> bookList = bookService.list(new QueryWrapper<Book>());
        return  CommonResultResponse.ok(bookList);
    }

    /**
    *  id删除
    */
    @ApiOperation(value = "id删除",notes = "通用结果返回对象")
    @PostMapping("book/delete")
    public CommonResult<Boolean> delete(Integer id){
        Boolean success = bookService.removeById(id);
        return CommonResultResponse.ok(success);
    }

    /**
    *  id查询
    */
    @ApiOperation(value = "id查询",notes = "通用结果返回对象")
    @GetMapping("book/findById")
    public CommonResult<Book> findById(Integer id){
        Book book = bookService.getById(id);
        return CommonResultResponse.ok(book);
    }

     /**
      *  新增
      */
     @ApiOperation(value = "新增",notes = "通用结果返回对象")
     @PostMapping("book/add")
     public CommonResult<Boolean> add(Book book){
        Boolean success = bookService.save(book);
        return CommonResultResponse.ok(success);
     }
}
package com.example.demo.test.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.test.entity.C;
import com.example.demo.test.service.CService;
import com.example.demo.bean.CommonResult;
import com.example.demo.bean.CommonResultResponse;
import java.util.List;
/**
* 
*
* @author lyc
* @date 2019-08-13 17:36:37
*/
@RestController
public class CController{

    @Autowired
    private CService cService;

    /**
    * 列表
    */
    @RequestMapping("c/list")
    public CommonResult<C> list(){
        List<C> cs = cService.list(new QueryWrapper<C>());
        return new CommonResultResponse<List<C>>().ok(cs);
    }

    /**
    *  id删除
    */
    @RequestMapping("c/delete")
    public CommonResult<C> delete(Integer id){
        Boolean success = cService.removeById(id);
        return new CommonResultResponse<Boolean>().ok(success);
    }

    /**
    *  id查询
    */
    @RequestMapping("c/findById")
    public CommonResult<C> findById(Integer id){
        C c = cService.getById(id);
        return new CommonResultResponse<C>().ok(c);
    }

     /**
      *  新增
      */
     @RequestMapping("c/findById")
     public CommonResult<C> add(C c){
        Boolean success = cService.save(c);
        return new CommonResultResponse<Boolean>().ok(success);
     }
}
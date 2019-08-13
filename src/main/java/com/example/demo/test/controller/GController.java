package com.example.demo.test.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.test.entity.G;
import com.example.demo.test.service.GService;
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
public class GController{

    @Autowired
    private GService gService;

    /**
    * 列表
    */
    @RequestMapping("g/list")
    public CommonResult<G> list(){
        List<G> gs = gService.list(new QueryWrapper<G>());
        return new CommonResultResponse<List<G>>().ok(gs);
    }

    /**
    *  id删除
    */
    @RequestMapping("g/delete")
    public CommonResult<G> delete(Integer id){
        Boolean success = gService.removeById(id);
        return new CommonResultResponse<Boolean>().ok(success);
    }

    /**
    *  id查询
    */
    @RequestMapping("g/findById")
    public CommonResult<G> findById(Integer id){
        G g = gService.getById(id);
        return new CommonResultResponse<G>().ok(g);
    }

     /**
      *  新增
      */
     @RequestMapping("g/findById")
     public CommonResult<G> add(G g){
        Boolean success = gService.save(g);
        return new CommonResultResponse<Boolean>().ok(success);
     }
}
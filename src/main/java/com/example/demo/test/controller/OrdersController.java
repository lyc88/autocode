package com.example.demo.test.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.test.entity.Orders;
import com.example.demo.test.service.OrdersService;
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
public class OrdersController{

    @Autowired
    private OrdersService ordersService;

    /**
    * 列表
    */
    @RequestMapping("orders/list")
    public CommonResult<Orders> list(){
        List<Orders> orderss = ordersService.list(new QueryWrapper<Orders>());
        return new CommonResultResponse<List<Orders>>().ok(orderss);
    }

    /**
    *  id删除
    */
    @RequestMapping("orders/delete")
    public CommonResult<Orders> delete(Integer id){
        Boolean success = ordersService.removeById(id);
        return new CommonResultResponse<Boolean>().ok(success);
    }

    /**
    *  id查询
    */
    @RequestMapping("orders/findById")
    public CommonResult<Orders> findById(Integer id){
        Orders orders = ordersService.getById(id);
        return new CommonResultResponse<Orders>().ok(orders);
    }

     /**
      *  新增
      */
     @RequestMapping("orders/findById")
     public CommonResult<Orders> add(Orders orders){
        Boolean success = ordersService.save(orders);
        return new CommonResultResponse<Boolean>().ok(success);
     }
}
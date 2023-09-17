package com.bjsxt.controller;

import com.bjsxt.common.pojo.Result;
import com.bjsxt.pojo.Produce;
import com.bjsxt.service.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class ProduceController {
    @Autowired
    private ProduceService produceService;

    //    添加订单数据
    @PostMapping("/addProd")
    public Result addProd(@RequestBody List<Produce> ps){
        System.out.println(ps);
        return produceService.addProd(ps);
    }
    //    查找订单数据
    @RequestMapping("/selectAllProd")
    public Result selectProd(){
        return produceService.selectProd();
    }
    @DeleteMapping("/deleteProd/{orderNumber}")
    public Result deleteProd(@PathVariable String orderNumber){
        return produceService.deleteProd(orderNumber);
    }
}

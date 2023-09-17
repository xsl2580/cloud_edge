package com.bjsxt.controller;

import com.bjsxt.common.pojo.Result;
import com.bjsxt.pojo.WorkCenterData;
import com.bjsxt.service.ProductionScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ProductionController {
    @Autowired
    private ProductionScheduleService productionScheduleService;

    @GetMapping("/getAllWorkCenterData")
    public Result getAllWorkCenterData(){
        return  productionScheduleService.getAllWorkCenterData();
    }

    @PostMapping("/saveAllWorkCenterData")
    public Result saveAllWorkCenterData(@RequestBody List<WorkCenterData> data){


        return productionScheduleService.saveAllWorkCenterData(data);
    }
}

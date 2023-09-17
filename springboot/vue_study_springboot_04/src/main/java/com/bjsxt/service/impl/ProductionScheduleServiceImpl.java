package com.bjsxt.service.impl;

import com.bjsxt.common.pojo.Result;
import com.bjsxt.mapper.WorkCenterDataMapper;
import com.bjsxt.pojo.Produce;
import com.bjsxt.pojo.WorkCenterData;
import com.bjsxt.service.ProductionScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionScheduleServiceImpl implements ProductionScheduleService {

    @Autowired
    private WorkCenterDataMapper workCenterDataMapper;

    @Override
    public Result getAllWorkCenterData() {
        List<WorkCenterData> allWorkCenterData = workCenterDataMapper.getAllWorkCenterData();
        if (allWorkCenterData != null){
            return Result.ok(allWorkCenterData);
        }
            return Result.error("没有查到数据！");
    }

    @Override
    public Result saveAllWorkCenterData(List<WorkCenterData> data) {

        for(WorkCenterData w:data){
            Integer integer = workCenterDataMapper.saveAllWorkCenterData(w);
            if (integer<0){
                return Result.error("存储失败！");
            }else {
                continue;
            }
        }
        return Result.ok();
    }
}

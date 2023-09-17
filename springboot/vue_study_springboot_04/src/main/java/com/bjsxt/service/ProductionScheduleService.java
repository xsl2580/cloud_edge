package com.bjsxt.service;

import com.bjsxt.common.pojo.Result;
import com.bjsxt.pojo.WorkCenterData;

import java.util.List;

public interface ProductionScheduleService {
//List<WorkCenterData>
    Result getAllWorkCenterData();

    Result saveAllWorkCenterData(List<WorkCenterData> data);

}

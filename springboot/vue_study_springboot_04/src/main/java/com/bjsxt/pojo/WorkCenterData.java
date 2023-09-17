package com.bjsxt.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkCenterData {
    private int workCenterIndex;
    private int startTime;
    private int endTime;
    private int processingTime;
    private int job;

    // 构造函数、getter和setter省略
}

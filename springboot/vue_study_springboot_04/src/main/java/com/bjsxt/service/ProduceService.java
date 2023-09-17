package com.bjsxt.service;

import com.bjsxt.common.pojo.Result;
import com.bjsxt.pojo.Produce;

import java.util.List;

public interface ProduceService {
//    添加订单数据
    Result addProd(List<Produce> ps);
//    查找订单数据
    Result selectProd();
    //删除订单
    Result deleteProd(String orderNumber);
}

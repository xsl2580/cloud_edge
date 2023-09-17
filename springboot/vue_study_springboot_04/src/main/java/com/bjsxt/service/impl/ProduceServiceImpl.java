package com.bjsxt.service.impl;

import com.bjsxt.common.pojo.Result;
import com.bjsxt.mapper.ProduceMapper;
import com.bjsxt.pojo.Produce;
import com.bjsxt.service.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class ProduceServiceImpl implements ProduceService {

    @Autowired
    private ProduceMapper produceMapper;

    //    添加订单数据
    @Override
    public Result addProd(List<Produce> ps){
        for(Produce p:ps){
            Integer integer = produceMapper.addProd(p);
            if (integer<0){
                return Result.error("添加订单失败！");
            }else {
                continue;
            }
        }
        return Result.ok();
    }
    //    查找订单数据
    @Override
    public Result selectProd(){
        List<Produce> prod = produceMapper.getProd();
        System.out.println("prod111111:"+prod);
        if (prod!=null){
            /*
            以产品数量从大到小排序
            * */
            Collections.sort(prod, new Comparator<Produce>() {
                @Override
                public int compare(Produce p1, Produce p2) {

                    return Integer.compare(p1.getNumber(), p2.getNumber());
                }
            });
            System.out.println("prod22222:" + prod);

            return Result.ok(prod);
        }else{
            return Result.error("没有订单信息！");
        }

    }

    //    //    查找订单数据
    @Override
    public Result deleteProd(String orderNumber) {
        Integer prod = produceMapper.deleteProd(orderNumber);
        System.out.println(prod);
        if (prod>0){
            return Result.ok("删除成功");
        }
        return Result.error("删除失败");
    }


}

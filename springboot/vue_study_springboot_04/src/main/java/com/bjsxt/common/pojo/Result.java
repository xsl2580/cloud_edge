package com.bjsxt.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lhp
 * @create 2021-09-07 14:59
 * 该类作为以后统一响应给前端的数据
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private Integer status; // 200 400 xxx
    private String msg; // 内容
    private Object data; //数据

    public static Result ok(){
        return new Result(200, null,null);
    }
    public static Result ok(Object data){
        return new Result(200, null,data);
    }
    public static Result error(String msg){
        return new Result(400, msg,null);
    }
}

package com.bjsxt.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produce {
    private String produce;
    private Integer number;
    private Long time;
    private Long orderNumber;
    private String requestArea;
    private String contactAddress;
    private String remark;
}

package com.jfx.springlearn.spring中常用设计模式.策略模式;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PayResult {
    private int code;
    private String msg;
    private Object data;

    @Override
    public String toString(){
        return ("支付状态:[ "+code+" ],"+msg+",交易详情 "+data);
    }

}

package com.jfx.springlearn.spring中常用设计模式.策略模式;

import com.jfx.springlearn.spring中常用设计模式.策略模式.enums.PayType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private String userId;
    private String orderId;
    private long amount;

    public PayResult pay(PayType payType){
        return payType.get().pay(userId,amount);
    }


}

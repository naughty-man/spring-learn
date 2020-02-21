package com.jfx.springlearn.spring中常用设计模式.策略模式.channels;

import com.jfx.springlearn.spring中常用设计模式.策略模式.PayChannel;
import com.jfx.springlearn.spring中常用设计模式.策略模式.PayResult;

public class WxPayChannel implements PayChannel {
    @Override
    public PayResult pay(String userId,long amount) {
        System.out.println("欢迎使用微信支付");
        System.out.println("查询账户余额，开始扣款");
        return new PayResult(200,"支付成功",amount);
    }
}

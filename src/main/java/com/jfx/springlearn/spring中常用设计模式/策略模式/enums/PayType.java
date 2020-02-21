package com.jfx.springlearn.spring中常用设计模式.策略模式.enums;

import com.jfx.springlearn.spring中常用设计模式.策略模式.PayChannel;
import com.jfx.springlearn.spring中常用设计模式.策略模式.channels.AliPayChannel;
import com.jfx.springlearn.spring中常用设计模式.策略模式.channels.WxPayChannel;

public enum PayType {

    ALI_pAY(new AliPayChannel()),
    WX_PAY(new WxPayChannel());

    private PayChannel payChannel;

    PayType(PayChannel payChannel) {
        this.payChannel = payChannel;
    }

    public PayChannel get(){
        return payChannel;
    }

}

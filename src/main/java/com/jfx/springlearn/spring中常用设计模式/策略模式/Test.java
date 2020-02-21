package com.jfx.springlearn.spring中常用设计模式.策略模式;

import com.jfx.springlearn.spring中常用设计模式.策略模式.enums.PayType;

public class Test {

    public static void main(String[] args) {
        //创建订单
        Order order=new Order("11598978","2020021800000001",90000);

        //拉起支付
        System.out.println(order.pay(PayType.ALI_pAY));
    }
}

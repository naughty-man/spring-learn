package com.jfx.springlearn.spring中常用设计模式.代理模式.静态代理;

public class Son implements Person {
    @Override
    public void findObject() {
        System.out.println("<== 要求是 肤白貌美大长腿");
    }
}

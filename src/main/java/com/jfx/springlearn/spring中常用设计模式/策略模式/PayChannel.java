package com.jfx.springlearn.spring中常用设计模式.策略模式;

public interface PayChannel {

    PayResult pay(String userId,long amount);

}

package com.jfx.springlearn.spring中常用设计模式.工厂模式.工厂方法模式;

import com.jfx.springlearn.spring中常用设计模式.工厂模式.简单工厂模式.Milk;
import com.jfx.springlearn.spring中常用设计模式.工厂模式.简单工厂模式.Yili;

public class YiliFactory implements Factory {
    @Override
    public Milk getMilk() {
        return new Yili();
    }
}

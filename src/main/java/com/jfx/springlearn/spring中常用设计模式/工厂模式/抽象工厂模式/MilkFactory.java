package com.jfx.springlearn.spring中常用设计模式.工厂模式.抽象工厂模式;

import com.jfx.springlearn.spring中常用设计模式.工厂模式.工厂方法模式.TelunsuFactory;
import com.jfx.springlearn.spring中常用设计模式.工厂模式.工厂方法模式.YiliFactory;
import com.jfx.springlearn.spring中常用设计模式.工厂模式.简单工厂模式.Milk;

public class MilkFactory extends AbstractFactory {
    @Override
    public Milk getTelunsu() {
        return new TelunsuFactory().getMilk();
    }

    @Override
    public Milk getYili() {
        return new YiliFactory().getMilk();
    }
}

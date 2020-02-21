package com.jfx.springlearn.spring中常用设计模式.工厂模式.抽象工厂模式;

import com.jfx.springlearn.spring中常用设计模式.工厂模式.简单工厂模式.Milk;

public abstract class AbstractFactory {

    public abstract Milk getTelunsu();
    public abstract Milk getYili();

}

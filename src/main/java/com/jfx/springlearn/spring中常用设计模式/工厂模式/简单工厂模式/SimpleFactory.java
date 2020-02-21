package com.jfx.springlearn.spring中常用设计模式.工厂模式.简单工厂模式;

/**
 * 简单工厂模式：特点：是复杂工厂模式的思维模型，批量生产，标准化
 *
 * 主要是为了解决原始社会要喝牛奶就得自己挤奶等操作
 * 代码层面为了解决一个复杂对象的构建，交给工厂去帮助我们实现
 * 不用每次都重复写大量代码去构建一个对象
 *
 * 缺点：不符合开闭原则，每次都会去更改工厂代码，并且一刀切的什么都生产，很杂乱不规范
 */
public class SimpleFactory {

    public String getMilk(String name){
        if("伊利".equals(name)){
            return new Yili().getName();
        }else if("特仑苏".equals(name)){
            return new Telunsu().getName();
        }
        return null;
    }

}

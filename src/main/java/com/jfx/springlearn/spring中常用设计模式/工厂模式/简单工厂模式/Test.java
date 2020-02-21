package com.jfx.springlearn.spring中常用设计模式.工厂模式.简单工厂模式;

public class Test {

    public static void main(String[] args) {
        SimpleFactory factory = new SimpleFactory();

        System.out.println(factory.getMilk("特仑苏"));
    }

}

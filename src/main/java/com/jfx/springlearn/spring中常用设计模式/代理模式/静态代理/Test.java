package com.jfx.springlearn.spring中常用设计模式.代理模式.静态代理;

public class Test {
    public static void main(String[] args) {
        Son xiaoming=new Son();

        //构造代理对象，代理自己的儿子小明
        Father father = new Father(xiaoming);
        father.findObject();
    }
}

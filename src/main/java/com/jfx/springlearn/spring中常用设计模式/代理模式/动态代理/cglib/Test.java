package com.jfx.springlearn.spring中常用设计模式.代理模式.动态代理.cglib;

public class Test {
    public static void main(String[] args) {
        Lisi proxyInstance = (Lisi)new CglibAgent().getInstance(Lisi.class);
        proxyInstance.findJob();

        System.out.println(proxyInstance.getClass());
    }

}

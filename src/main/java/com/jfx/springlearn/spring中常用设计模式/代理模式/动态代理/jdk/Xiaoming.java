package com.jfx.springlearn.spring中常用设计模式.代理模式.动态代理.jdk;

/**
 * 只能代理实现了接口的类，其他类不能代理
 */
public class Xiaoming implements JobHunter {
    @Override
    public void findJob() {
        System.out.println("我要找月薪20K以上双休的工作");
    }
}

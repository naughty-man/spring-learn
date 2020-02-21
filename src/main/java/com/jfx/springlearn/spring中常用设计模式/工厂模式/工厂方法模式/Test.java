package com.jfx.springlearn.spring中常用设计模式.工厂模式.工厂方法模式;

/**
 * 工厂方法模式
 *
 * 流水线式样：一个流水线只生产一种商品
 *
 * 优点：不再像简单工厂（小作坊）式的一刀切，什么都生产，标准化，特仑苏工厂只生产特仑苏，伊利工厂只生产伊利
 * 缺点：用户要喝那个牛奶，还得去创建对应牛奶的工厂，多了个还得自己选择的步骤
 */
public class Test {

    public static void main(String[] args) {
        Factory factory=new TelunsuFactory();
        System.out.println(factory.getMilk());
    }

}

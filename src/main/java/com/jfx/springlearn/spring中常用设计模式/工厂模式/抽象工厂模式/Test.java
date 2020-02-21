package com.jfx.springlearn.spring中常用设计模式.工厂模式.抽象工厂模式;

/**
 * 抽象工厂模式
 *
 * 用户不再需要考虑创建什么工厂，只需要直接根据一个工厂来获取牛奶
 *
 * 并且不像简单工厂，可能存在传错工厂中不能生产的物品的情况，
 * 抽象工厂模式，只允许用户选择工厂可以生产的产品
 *
 * 下面例子为抽象工厂模式+简单工厂模式，如果去掉milkFactory中穿件
 * 对相应牛奶工厂的步骤改为创建对应牛奶，则是完全的抽象工厂模式
 */
public class Test {

    public static void main(String[] args) {
        MilkFactory milkFactory = new MilkFactory();
        System.out.println(milkFactory.getYili());
    }

}

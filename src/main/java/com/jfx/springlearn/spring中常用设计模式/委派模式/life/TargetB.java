package com.jfx.springlearn.spring中常用设计模式.委派模式.life;

public class TargetB implements ITarget {
    @Override
    public void doing() {
        System.out.println("执行后端工作");
    }
}

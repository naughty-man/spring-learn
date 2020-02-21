package com.jfx.springlearn.spring中常用设计模式.委派模式.life;

public class TargetA implements ITarget {
    @Override
    public void doing() {
        System.out.println("执行前端工作");
    }
}

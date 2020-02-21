package com.jfx.springlearn.spring中常用设计模式.观察者模式;

class Student {

    void notify(Event e){
        System.out.println("=====触发事件，打印日志====="+e);
    }

}

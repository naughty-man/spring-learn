package com.jfx.springlearn.spring中常用设计模式.观察者模式;

import lombok.Data;
import lombok.ToString;

import java.lang.reflect.Method;

@Data
@ToString
public class Event {

    //谁产生的这个事件，比如老师
    private Object source;

    //谁订阅了这个事件，即产生的事件需要通知的目标，比如学生
    private Object target;

    //回调函数，收到这个事件以后要做什么事情
    private Method callback;

    //这个事件是由哪个方法触发的，方法名称
    private String triggerMethod;

    //事件发生的时间
    private long time;

    //构造器，通过目标和回调构造事件
    public Event(Object target, Method callback) {
        this.target = target;
        this.callback = callback;
    }
}

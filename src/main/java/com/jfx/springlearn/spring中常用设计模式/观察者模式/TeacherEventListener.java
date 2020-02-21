package com.jfx.springlearn.spring中常用设计模式.观察者模式;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 此类仅仅是为了补充teacher发布类
 */
class TeacherEventListener {

    private Map<Enum,Event> eventMap=new HashMap<>();

    void addListener(Enum eventType, Object target, Method callback){
        //注册事件
        //用反射调用这个callback。所以需要传入这个callback
        eventMap.put(eventType,new Event(target,callback));
    }

    //传入是谁触发的
    void trigger(Enum call) {
        if(!this.eventMap.containsKey(call)){
            return;
        }

        Event event = this.eventMap.get(call);

        //打印call这个enum的toString
        event.setTriggerMethod(call.toString());
        event.setSource(this);
        event.setTime(System.currentTimeMillis());

        //执行event这个回调方法，第一个参数是要执行哪个类，第二个参数是参数
        try {
            // Object Java.lang.reflect.Method.invoke(Object receiver, Object... args)
            // receiver：该方法所在类的一个对象
            // args： 传入的参数 如 100，“hello”
            event.getCallback().invoke(event.getTarget(),event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

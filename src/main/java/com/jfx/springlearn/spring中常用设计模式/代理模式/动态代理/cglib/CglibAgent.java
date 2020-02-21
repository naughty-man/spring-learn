package com.jfx.springlearn.spring中常用设计模式.代理模式.动态代理.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibAgent implements MethodInterceptor {

    Object getInstance(Class<?> clazz){
        Enhancer enhancer=new Enhancer();
        //为代理的类生成子类，即代理类需要继承谁
        enhancer.setSuperclass(clazz);

        //设置通过自己毁掉
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("这里是工作介绍中心，我将为你介绍工作，你的要求是什么");
        //真正的调用过程
        methodProxy.invokeSuper(o, objects);

        return null;
    }
}

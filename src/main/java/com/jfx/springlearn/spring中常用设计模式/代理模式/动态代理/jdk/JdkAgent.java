package com.jfx.springlearn.spring中常用设计模式.代理模式.动态代理.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 中间类，用于动态构造代理类的调用处理器，***非代理类 ***
 *
 *
 *
 */
public class JdkAgent implements InvocationHandler {

    //被代理对象
    private JobHunter target;

    /**
     * 创建代理类对象
     *
     * @param target
     * @return 代理对象
     */
    public Object getInstance(JobHunter target){
        this.target=target;
        Class<? extends JobHunter> aClass = target.getClass();
        //第二个参数是实现的所有接口
        return Proxy.newProxyInstance(aClass.getClassLoader(),aClass.getInterfaces(),this);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("这里是工作介绍中心，我将为你介绍工作，你的要求是什么");
        method.invoke(target,args);
        return null;
    }
}

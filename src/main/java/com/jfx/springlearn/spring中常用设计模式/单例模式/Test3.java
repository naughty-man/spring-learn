package com.jfx.springlearn.spring中常用设计模式.单例模式;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * 注册登记式单例
 */
public class Test3 {

    private static ConcurrentHashMap<String, Object> ioc = new ConcurrentHashMap<>();

    private static String classForName="com.jfx.springlearn.lesson1.Test3";

    //此静态object也可
    private static Object lockObject=new Object();

    private static Object getInstance(String className) throws Exception {
        //锁防盗这里不合适，防盗这里每个线程都有自己的一把锁
//        Object o1=new Object();
        synchronized (Test3.class) {
            System.out.println(Thread.currentThread().getName()+" 容器内容有 "+ioc);
            if (ioc.containsKey(className)) {
                return ioc.get(className);
            }else{
                Class<?> aClass = Class.forName(className);
                Object o = aClass.newInstance();
                ioc.put(className, o);
                return o;
            }


        }
    }


    public static void main(String[] args) {
        int nThread=3;
        Thread[] threads=new Thread[3];
        for(int i=0;i<nThread;i++){
            threads[i]=new Thread(() -> {
                try {
                    System.out.println(
                            Thread.currentThread().getName()+" ==>"+Test3.getInstance(classForName));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main finished");

    }

}

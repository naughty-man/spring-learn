package com.jfx.springlearn.spring中常用设计模式.单例模式;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 懒汉式+静态类方式
 *
 */
public class Test2 {


    //防止通过反射强行访问私有构造方法，暴力破解，直接创建对象
    private boolean initialized=false;
    //禁止通过无参构造对象
    private Test2(){
        synchronized (Test3.class){
            if(!initialized){
                initialized= true;
            }else{
                throw new RuntimeException("单例已被侵犯");
            }
        }
    }

    //加final保证方法不会被重写
    private final static Object getInstance(){
        return LazyInnerClass.obj;
    }

    /**
     * 静态内部类创建对象，不像饿汉式上来就创建
     *
     * 内部类默认不加载，只有在调用外部类的getInstance方法的时候才会加载
     *
     * 外部类加载时并不需要立即加载内部类，内部类不被加载则不去初始化INSTANCE，故而不占内存
     */
    private static class LazyInnerClass{
        private static final Test2 obj = new Test2();
    }

    public static void main(String[] args) {
        int nThread=4;
        Thread[] threads=new Thread[nThread];


        //模拟线程同一时间启动，采用发令枪机制   注意：：：时间纳秒数仍然不同！！！需要测试
        //此处加不加countdownlatch都一样
        CountDownLatch latch= new CountDownLatch(nThread);

        for(int i=0;i<nThread;i++){
            threads[i]=new Thread(() -> {
                try {

                    //所有线程准备好之前让他一直等待
                    //count=0时候，释放共享锁，万箭齐发
                    latch.await();

                    System.out.println(
                            "当前时间戳 ["+System.currentTimeMillis()+"] "+
                            Thread.currentThread().getName()+" ==>"
                                    +Test2.getInstance());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();

            //启动成功就倒数-1，减到0，所有线程在await处醒来开始执行

            //这里是运动员开始跑步
            latch.countDown();

        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main finished");

    }


}

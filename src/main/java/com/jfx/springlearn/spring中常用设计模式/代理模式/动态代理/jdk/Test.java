package com.jfx.springlearn.spring中常用设计模式.代理模式.动态代理.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        Object proxyObject = new JdkAgent().getInstance(new Xiaoming());
        JobHunter hunter = (JobHunter) proxyObject;
        hunter.findJob();

        // class com.sun.proxy.$Proxy0
        System.out.println("生成的代理类的类是:"+hunter.getClass());


        /*
          jdk字节码重组
          1. 拿到被代理对象的引用，并且获取到他锁实现的所有接口，反射获取
          2. 通过JDK Proxy类重新生成一个新的类，同时新的类要实现被代理类所有实现的接口
          3. 动态生成java代码，把新加的业务逻辑方法由一定的逻辑代码去调用
          4. 编译新生成的java代码为.class字节码文件
          5. 再重新加载到JVM中运行

         * jdk中有个规范，只要类名是$开头的，一般都是自动生成的
         */

        // 输出这个代理类查看，第二个参数是生成哪个类的代理对象
        byte[] bytes=ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{JobHunter.class});
        try {
            FileOutputStream fos=new FileOutputStream("E:\\home\\spring-learn\\src\\main\\java\\com\\jfx\\springlearn\\lesson1\\代理模式\\动态代理\\jdk\\$Proxy0.class");
            fos.write(bytes);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

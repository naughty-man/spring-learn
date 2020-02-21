package com.jfx.springlearn.spring中常用设计模式.代理模式.静态代理;

public class Father implements Person {

    private Person person;

    public Father(Person person){
        this.person=person;
    }

    @Override
    public void findObject() {
        System.out.println("==> 儿子，你找啥样的女子");
        person.findObject();
        System.out.println("==> 好的儿子，我知道了");
    }
}

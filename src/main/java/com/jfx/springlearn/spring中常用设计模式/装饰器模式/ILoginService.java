package com.jfx.springlearn.spring中常用设计模式.装饰器模式;

public interface ILoginService {

    public Object register(String username,String password);
    public Object login(String username,String password);

}

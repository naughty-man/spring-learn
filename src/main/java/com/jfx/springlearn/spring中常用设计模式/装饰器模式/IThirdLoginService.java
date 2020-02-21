package com.jfx.springlearn.spring中常用设计模式.装饰器模式;

public interface IThirdLoginService extends ILoginService {

    public Object wxLogin(String openId);

}

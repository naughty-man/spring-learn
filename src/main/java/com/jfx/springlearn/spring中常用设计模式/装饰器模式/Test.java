package com.jfx.springlearn.spring中常用设计模式.装饰器模式;

import com.jfx.springlearn.spring中常用设计模式.适配器模式.LoginService;

public class Test {

    public static void main(String[] args) {
        ILoginService loginService = new ThirdLoginService(new LoginService());
        loginService.login("","");
    }

}

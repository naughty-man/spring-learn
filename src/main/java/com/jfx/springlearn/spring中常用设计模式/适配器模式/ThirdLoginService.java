package com.jfx.springlearn.spring中常用设计模式.适配器模式;

import org.springframework.beans.factory.annotation.Autowired;

public class ThirdLoginService {

    @Autowired
    LoginService loginService;

    public Object QQLogin(String openId){
        //openId是全局唯一的（用户名也是全局唯一的，我们可以将其看成一个用户名）
        //2 密码默认QQ_EMPTY
        //3 在原系统中注册一个用户
        //4 使用原来的登录方法
        Object regResult = loginService.register(openId, "QQ_EMPTY");

        Object loginMsg = loginService.login(openId, "QQ_EMPTY");

        return loginMsg;
    }

}

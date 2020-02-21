package com.jfx.springlearn.spring中常用设计模式.适配器模式;

import com.jfx.springlearn.spring中常用设计模式.装饰器模式.ILoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements ILoginService {

    public Object register(String username,String password){
        return null;
    }

    public Object login(String username,String password){
        return null;
    }

}

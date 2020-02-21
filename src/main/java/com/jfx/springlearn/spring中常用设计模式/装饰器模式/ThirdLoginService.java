package com.jfx.springlearn.spring中常用设计模式.装饰器模式;

public class ThirdLoginService implements IThirdLoginService{

    ILoginService iLoginService;

    public ThirdLoginService(ILoginService iLoginService) {
        this.iLoginService = iLoginService;
    }

    @Override
    public Object register(String username, String password) {
        return iLoginService.register(username,password);
    }


    /**
     * 没有改变原来方法，同时也可以重写原来的方法
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public Object login(String username, String password) {
        return iLoginService.login(username,password);
    }

    @Override
    public Object wxLogin(String openId) {
        return null;
    }
}

package com.jfx.springlearn.spring中常用设计模式.委派模式.mvc;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ServletDispatcher {

    private static List<Handler> handlerMapping = new ArrayList<>();

    static {
        Class<UserController> ucClass = UserController.class;
        Handler handler1=new Handler();
        try {
            handler1.setController(ucClass.newInstance());
            handler1.setMethod(ucClass.getMethod("getUserById", String.class, String.class));
            handler1.setUrl("/user/getUserById");
            handlerMapping.add(handler1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
        doDispatch(request,response);
    }

    public void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取用户请求的url
        String uri=request.getRequestURI();

        Handler h = null;

        //找到该url对应的handler,这是策略常量
        for(Handler handler:handlerMapping){
            if(handler.getUrl().equals(uri)){
                h=handler;
                break;
            }
        }

        //将具体的人物分发给Method（通过反射调用方法）
        Object result = h.getMethod().invoke(h.getController(),
                request.getParameter("userid"),
                request.getParameter("username"));

        //获取到method执行结果通过response返回
        response.getWriter().write(result.toString());

    }

    @Data
    @NoArgsConstructor
    static class Handler{
        private Object controller;
        private Method method;
        private String url;
    }

}

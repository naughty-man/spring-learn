package com.jfx.springlearn.spring中常用设计模式.委派模式.life;

import java.util.HashMap;
import java.util.Map;

public class ProjectManager {

    private Map<String,ITarget> handlerMapping=new HashMap<>();

    public ProjectManager(){
        handlerMapping.put("前端",new TargetA());
        handlerMapping.put("后端",new TargetB());

    }

    public void doing(String commond){
        handlerMapping.get(commond).doing();
    }


}

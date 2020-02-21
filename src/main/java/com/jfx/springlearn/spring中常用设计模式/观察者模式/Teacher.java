package com.jfx.springlearn.spring中常用设计模式.观察者模式;

class Teacher extends TeacherEventListener {


    //通常，采用动态代理实现监控，避免代码侵入

    /**
     * 开始上课
     */
    void startClass(){
        System.out.println("调用上课的方法");
        trigger(TeacherEventEnum.ON_START_CLASS);
    }

    /**
     * 下课
     */
    void endClass(){
        System.out.println("调用下课的方法");
        trigger(TeacherEventEnum.ON_END_CLASS);
    }

}

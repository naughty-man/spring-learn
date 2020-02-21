package com.jfx.springlearn.spring中常用设计模式.观察者模式;

import java.lang.reflect.Method;

/**
 *             // Object Java.lang.reflect.Method.invoke(Object receiver, Object... args)
 *             // receiver：该方法所在类的一个对象
 *             // args： 传入的参数 如 100，“hello”
 */
public class Test {
    public static void main(String[] args) {
        //观察者
        Student student=new Student();
        Method notifyMethod=null;
        try {
            notifyMethod=Student.class.getMethod("notify", Event.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //老师的每个动作都被观察者学生所观察
        Teacher teacher=new Teacher();
        teacher.addListener(TeacherEventEnum.ON_START_CLASS,student,notifyMethod);
        teacher.addListener(TeacherEventEnum.ON_END_CLASS,student,notifyMethod);


        teacher.startClass();
        System.out.println("---------------------------------------------------");
        teacher.endClass();
    }

}

package com.jfx.springlearn.spring中常用设计模式.原型模式;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO,VO,POJO,Entity
 *
 * DTO和VO之间存在一些属性名称、类型都相同
 * 数据库中表查询出来的对象会赋值给DTO
 * 把DTO中的值会赋值给VO
 * 然后再将VO中的值传输到View中去
 *
 */
public class Test1 implements Serializable {
    public static void main(String[] args) throws Exception {
        CloneTarget obj=new CloneTarget();

        obj.name="孙悟空";

        CloneTarget cloneObj = (CloneTarget) obj.clone();

        System.out.println("原对象地址 "+obj);
        System.out.println("克隆对象地址 "+cloneObj);
        System.out.println(cloneObj.name);

        /*
         * 下面是打印对象的list地址，结果发现持有的list引用是一样的，这是浅拷贝，肯定是不能符合我们的要求的
         *
         * 我们需要保证每个属性都是独立的，应该是克隆一份新的list和里面的对象，不能是指向以前的
         */
        System.out.println("原对象list地址 "+ obj.list+" 原对象list大小 [ "+obj.list.size()+" ]");
        System.out.println("克隆对象list地址 "+cloneObj.list+" 克隆对象list大小 [ "+cloneObj.list.size()+ "]");

        System.out.println(obj.testAdd);
        System.out.println(cloneObj.testAdd);

        System.out.println(obj.birthday);
        System.out.println(cloneObj.birthday);
    }
}


/**
 * jdk提供的拷贝
 *
 * 默认浅拷贝，复制的对象的引用，引用地址的值变了，所有的值都会变
 * 深拷贝：复制的是值，复制出来的值变了，被复制的值还是原来的值
 */
class CloneTarget implements Cloneable,Serializable{

    String name;

    Test1 testAdd = new Test1();

    long birthday = System.currentTimeMillis();

    /**
     * 使用匿名内部类初始化list
     */
    List<Integer> list = new ArrayList(){
        @Override
        public String toString() {
            return ArrayList.class.getName() + "@" + Integer.toHexString(hashCode());
        }
    };

    @Override
    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
        return deepClone();
    }

    /**
     * 序列化/反序列化方式实现深度拷贝
     *
     * 原理：将对象的字节码数组读出来，通过这个对象的字节码数组再重新构造成一个新的对象
     * @return
     */
    private Object deepClone(){

        try {
            //字节数组输出流
            ByteArrayOutputStream bos=new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            CloneTarget obj = (CloneTarget)ois.readObject();


            obj.birthday=System.currentTimeMillis();

            return obj;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
package com.jfx.springlearn.spring中常用设计模式.模板模式.优化前版本;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        MemberDao memberDao=new MemberDao(null);
        List<Object> result = memberDao.executeQuery("select * from user", null);
    }

}

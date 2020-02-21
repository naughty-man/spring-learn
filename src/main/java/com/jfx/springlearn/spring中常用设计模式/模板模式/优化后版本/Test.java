package com.jfx.springlearn.spring中常用设计模式.模板模式.优化后版本;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        MemberDao memberDao = new MemberDao();
        List<Object> result = memberDao.queryUses();
    }
}

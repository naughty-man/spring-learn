package com.jfx.springlearn.spring中常用设计模式.模板模式.优化前版本;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao extends JdbcTemplate {


    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    protected Object processResult(ResultSet rs,int rowNum) throws SQLException {
        Member member=new Member();
        member.setUsername(rs.getString("username"));
        member.setPassword(rs.getString("password"));
        member.setAge(rs.getInt("age"));
        member.setAddress(rs.getString("address"));
        return member;
    }
}

package com.jfx.springlearn.spring中常用设计模式.模板模式.优化后版本;

import com.jfx.springlearn.spring中常用设计模式.模板模式.优化前版本.Member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MemberDao {

    //静态代理模式，次有被代理对象的引用
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(null);

    public List<Object> queryUses(){
        return jdbcTemplate.executeQuery("select * from user", null, new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                Member member=new Member();
                member.setUsername(rs.getString("username"));
                member.setPassword(rs.getString("password"));
                member.setAge(rs.getInt("age"));
                member.setAddress(rs.getString("address"));
                return member;
            }
        });
    }


}

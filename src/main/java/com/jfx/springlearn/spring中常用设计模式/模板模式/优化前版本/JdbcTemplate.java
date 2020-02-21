package com.jfx.springlearn.spring中常用设计模式.模板模式.优化前版本;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 这是最原始的写法，spring的jdbctemplate其实并不是一个抽象类，我们也不需要继承他，
 * 因此，引入下一个概念，接口rowMapper来实现抽象类的抽象方法
 *
 * 即 优化后的版本
 */
public abstract class JdbcTemplate {

    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Object> executeQuery(String sql,Object[] args) {
        try {
            //获取连接
            Connection conn = dataSource.getConnection();
            //创建语句集
            PreparedStatement pst = conn.prepareStatement(sql);
            //执行语句集，获取结果集
            ResultSet rs = pst.executeQuery();

            //解析结果集,唯一可以定制的一部分
            List<Object> result = new ArrayList<>();
            int rowNum=1;
            while (rs.next()){
                result.add(processResult(rs,rowNum++));
            }

            //关闭结果集
            rs.close();
            //关闭语句集
            pst.close();
            //关闭连接
            conn.close();
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    protected abstract Object processResult(ResultSet rs,int rowNum) throws SQLException;


}

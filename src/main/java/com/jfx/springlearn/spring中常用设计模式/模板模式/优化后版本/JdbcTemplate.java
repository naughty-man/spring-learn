package com.jfx.springlearn.spring中常用设计模式.模板模式.优化后版本;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate {

    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //抽取出方法
    private Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }
    private PreparedStatement createPst(Connection conn,String sql) throws SQLException {
        return conn.prepareStatement(sql);
    }
    private ResultSet executeQuery(PreparedStatement pst,Object[] args) throws SQLException {
        for(int i=1;i<=args.length;i++){
            pst.setObject(i,args[i]);
        }
        return pst.executeQuery();
    }
    private void closeRs(ResultSet rs) throws SQLException {
        rs.close();
    }
    private void closePst(PreparedStatement pst) throws SQLException {
        pst.close();
    }
    private void closeConn(Connection conn) throws SQLException {
        //此处并不会直接关闭，一般连接池管理，是归还到连接池中的，所以此处先不写实现
    }

    public List<Object> executeQuery(String sql, Object[] args,RowMapper<?> rowMapper) {
        try {
            //获取连接
            Connection conn = getConnection();
            //创建语句集
            PreparedStatement pst = createPst(conn,sql);
            //执行语句集，获取结果集
            ResultSet rs = executeQuery(pst,args);

            //解析结果集,唯一可以定制的一部分
            List<Object> result = new ArrayList<>();
            int rowNum=1;
            while (rs.next()){
                result.add(rowMapper.mapRow(rs,rowNum));
            }

            //关闭结果集
            closeRs(rs);
            //关闭语句集
            closePst(pst);
            //关闭连接
            closeConn(conn);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


}

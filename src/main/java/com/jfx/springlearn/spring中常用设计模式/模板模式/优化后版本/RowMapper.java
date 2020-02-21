package com.jfx.springlearn.spring中常用设计模式.模板模式.优化后版本;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {

    T mapRow(ResultSet rs,int rowNum) throws SQLException;

}

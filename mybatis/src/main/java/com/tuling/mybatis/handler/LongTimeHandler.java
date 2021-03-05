package com.tuling.mybatis.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;

public class LongTimeHandler extends BaseTypeHandler<Long> {

    public void setNonNullParameter(PreparedStatement ps, int i, Long paramter, JdbcType jdbcType) throws SQLException {
        ps.setDate(i, new Date(paramter));
    }

    public Long getNullableResult(ResultSet rs, String s) throws SQLException {
        return rs.getDate(s).getTime();
    }

    public Long getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getDate(i).getTime();
    }

    public Long getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return callableStatement.getDate(i).getTime();
    }
}

package com.votre.microservices.products.repository.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.UnaryOperator;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(String.class)
@MappedJdbcTypes(value = {JdbcType.CHAR, JdbcType.VARCHAR}, includeNullJdbcType = true)
public class StringTrimTypeHandler extends BaseTypeHandler<String> {

    private UnaryOperator<String> trim = value -> value == null ? value : value.trim();

    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return this.trim.apply(rs.getString(columnName));
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return trim.apply(rs.getString(columnIndex));
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return trim.apply(cs.getString(columnIndex));
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType)
        throws SQLException {
        ps.setString(i, parameter);
    }

}

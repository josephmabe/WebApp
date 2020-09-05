package com.example.demo;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.boot.jdbc.DataSourceBuilder;
import javax.sql.DataSource;
//
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Collections;
import java.util.Map;

interface Query {
    /*List<Phone> findAll();

    List<Phone> findByMakeOrModel(String searchTerm);
    */
    List<Phone> countRow(String make);
};

class DatabaseQuery implements Query{

    @Override
    public List<Phone> countRow(String make) {


        JdbcTemplateFactory Factory = new JdbcTemplateFactory();
        NamedParameterJdbcTemplate template = Factory.getTemplate();

        String sql = "select * from Phone where make = :make";
        Map namedParameters = Collections.singletonMap("make", make);
        return template.queryForList(sql, namedParameters);
    }
    /*
    @Override
    public List<Phone> findByMakeOrModel(String searchTerm){
        String sqlQuery = "SELECT p from Phone p WHERE " +
                "LOWER(p.make) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
                "LOWER(p.model) LIKE LOWER(CONCAT('%',:searchTerm, '%'))";

        JdbcTemplateFactory Factory = new JdbcTemplateFactory();
        NamedParameterJdbcTemplate template = Factory.getTemplate();

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("searchTerm", searchTerm);
        return template.query(sqlQuery, params);
    }

    @Override
    public List<Phone> findAll() {
        String sqlQuery = "SELECT * FROM Phone p";

        JdbcTemplateFactory Factory = new JdbcTemplateFactory();
        NamedParameterJdbcTemplate template = Factory.getTemplate();

        return template.query(sqlQuery, new RowMapper<Phone>)
     }
     */
}
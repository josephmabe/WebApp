package com.example.demo;


import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Collections;
import java.util.Map;

@RestController
interface Query {

    List<Phone> findByMakeOrModel(String searchTerm);
}

class DatabaseQuery implements Query{

    @Override
    public List<Phone> findByMakeOrModel(String searchTerm) {

        JdbcTemplateFactory Factory = new JdbcTemplateFactory();
        NamedParameterJdbcTemplate template = Factory.getTemplate();

        String sql = "select * from Phone where make = :searchTerm OR model =:searchTerm";
        Map namedParameters = Collections.singletonMap("searchTerm", searchTerm);
        return template.queryForList(sql, namedParameters);
    }
}
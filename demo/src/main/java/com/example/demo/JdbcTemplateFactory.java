package com.example.demo;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.boot.jdbc.DataSourceBuilder;
import javax.sql.DataSource;

interface TemplateFactory {
    NamedParameterJdbcTemplate getTemplate();
}

public class JdbcTemplateFactory implements TemplateFactory{

    private final String JDBC_URL_TEMPLATE = "jdbc:mysql://localhost:3306/webapp";
    private final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final DatabaseConnectionConfig connectionDetails = new DatabaseConnectionConfig();

    private final DataSource ds = createDataSource(connectionDetails);

    public NamedParameterJdbcTemplate getTemplate(){
        return new NamedParameterJdbcTemplate(ds);
    }

    private DataSource createDataSource(DatabaseConnectionConfig connectionDetails){
        return DataSourceBuilder.create().driverClassName(MYSQL_DRIVER)
                .url(JDBC_URL_TEMPLATE)
                .username(connectionDetails.username)
                .password(connectionDetails.password).build();
    }
}

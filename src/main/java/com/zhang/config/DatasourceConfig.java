package com.zhang.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {

    /****
     *  构建多个数据源
     * @return
     */
    @Primary
    @Bean("primaryDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDatasource(){
        return DataSourceBuilder.create().build();
    }

    @Bean("secondaryDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource secondaryDatasource(){
        return DataSourceBuilder.create().build();
    }

    /****
     *  构建 JDBCtemplate
     *
     */

    @Bean("primaryJdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDatasource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean("secondaryJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDatasource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

}

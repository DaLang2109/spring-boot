package com.zhang.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {

    /****
     * 构建多个数据源
     * @return
     */

    @Primary
    @Bean(name = "primaryDatasource",initMethod = "init",destroyMethod = "close")
    @ConfigurationProperties(prefix = "primarydb")
    public DataSource primaryDatasource(){
        return new AtomikosDataSourceBean();
    }

    @Bean(name = "secondaryDatasource",initMethod = "init",destroyMethod = "close")
    @ConfigurationProperties(prefix = "secondarydb")
    public DataSource secondaryDatasource(){
        return new AtomikosDataSourceBean();
    }

    /****
     * 构建 JDBCtemplate
     * @param dataSource
     * @return
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

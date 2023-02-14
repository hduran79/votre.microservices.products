package com.votre.microservices.products.config.mybatis;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(value = "com.votre.microservices.products.repository.payment",
    sqlSessionFactoryRef = "votreSessionFactory")
public class MyBatisConfiguration {

    private static final String VOTRE_SESSION_FACTORY = "votreSessionFactory";
    public static final String VOTRE_DATASOURCE = "votreDatasource";
    
    private static final String VOTRE_HANDLER_PACKAGE = "com.votre.microservices.products.repository.handler";
    
    private static final String VOTRE_ALIAS_PACKAGE = "com.votre.microservices.products.dto.payment";

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.votre")
    public DataSourceProperties votreDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = VOTRE_DATASOURCE)
    @Primary
    public DataSource dataSourceVotre() {
        HikariDataSource dataSource = (HikariDataSource) votreDataSourceProperties()
            .initializeDataSourceBuilder()
            .build();
        dataSource.setConnectionTestQuery("values 1");

        return dataSource;
    }

    @Bean(name = VOTRE_SESSION_FACTORY)
    @Primary
    public SqlSessionFactory votreSessionFactory() throws Exception {
        var factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSourceVotre());
        factoryBean.setTypeHandlersPackage(VOTRE_HANDLER_PACKAGE);
        factoryBean.setTypeAliasesPackage(VOTRE_ALIAS_PACKAGE);

        return factoryBean.getObject();
    }

}

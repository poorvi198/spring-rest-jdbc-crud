package org.springapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@ComponentScan("org.springapp")
@EnableWebMvc
@PropertySource("classpath:datasource.properties")
public class SpringJDBCConfig {

    @Autowired
    Environment environment;

    @Bean
    public DataSource dataSource(){

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("driver"));
        dataSource.setUrl(environment.getProperty("url"));
        dataSource.setPassword(environment.getProperty("password"));
        dataSource.setUsername(environment.getProperty("user"));
        return dataSource;
    }
}

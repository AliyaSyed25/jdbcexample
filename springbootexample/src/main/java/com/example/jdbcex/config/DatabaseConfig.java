package com.example.jdbcex.config;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatabaseConfig {

    @Bean(name = "spring")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
	@Bean
public JdbcTemplate template(@Qualifier("spring") DataSource data) {
		try{
			
		return new JdbcTemplate(data);
		}catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	

}
}
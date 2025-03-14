package com.example.jdbcex.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;

@Getter
@Configuration
@PropertySource("classpath:sql.properties")
public class SqlConfig {
	@Value("${sql.insert.laptop}")
	private String insert;

	@Value("${sql.update.laptop}")
	private String update;

	@Value("${sql.delete.laptop}")
	private String deleteById;

//private String deleteAll;
	@Value("${sql.select.all.laptops}")
	private String getAll;

	@Value("${sql.select.laptop.by.id}")
	private String getById;
}

package com.example.jdbcex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootApplication
public class SpringbootexampleApplication {

	public static void main(String[] args) {
		log.info("----------Application running --------------");
		SpringApplication.run(SpringbootexampleApplication.class, args);
		log.info("----------Application running success --------------");
	}

}

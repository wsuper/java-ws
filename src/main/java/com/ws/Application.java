package com.ws;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;

@SpringBootApplication
@ComponentScan
@MapperScan("com.ws.dao")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

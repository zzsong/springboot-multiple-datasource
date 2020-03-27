package com.zss.one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class MultipleDataSourceOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultipleDataSourceOneApplication.class, args);
	}

}

package com.zss.third;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class MultipleDataSourceThirdApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultipleDataSourceThirdApplication.class, args);
	}

}

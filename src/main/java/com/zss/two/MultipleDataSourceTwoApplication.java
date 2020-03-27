package com.zss.two;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class MultipleDataSourceTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultipleDataSourceTwoApplication.class, args);
	}

}

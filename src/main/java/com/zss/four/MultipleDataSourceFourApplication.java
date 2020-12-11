package com.zss.four;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class MultipleDataSourceFourApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultipleDataSourceFourApplication.class, args);
	}

}

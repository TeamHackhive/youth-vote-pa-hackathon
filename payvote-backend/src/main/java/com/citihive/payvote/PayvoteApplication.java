package com.citihive.payvote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class PayvoteApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PayvoteApplication.class, args);
	}

}

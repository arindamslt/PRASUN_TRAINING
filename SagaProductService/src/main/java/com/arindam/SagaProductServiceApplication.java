package com.arindam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SagaProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SagaProductServiceApplication.class, args);
	}

}

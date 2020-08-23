package com.epam.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.epam")
@EnableJpaRepositories("com.epam.repository")
@EntityScan("com.epam.entity")
@EnableFeignClients("com.epam")
public class OrderItemApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderItemApiApplication.class, args);
	}

}

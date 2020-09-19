package com.erhan.bestcommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BestCommerceSignUpMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BestCommerceSignUpMicroServiceApplication.class, args);
	}

}

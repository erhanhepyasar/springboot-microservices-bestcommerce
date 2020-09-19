package com.erhan.bestcommerce.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BestCommerceDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BestCommerceDiscoveryServiceApplication.class, args);
	}

}

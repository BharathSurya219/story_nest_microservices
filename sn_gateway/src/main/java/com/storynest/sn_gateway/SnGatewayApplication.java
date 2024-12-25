package com.storynest.sn_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SnGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnGatewayApplication.class, args);
	}

}

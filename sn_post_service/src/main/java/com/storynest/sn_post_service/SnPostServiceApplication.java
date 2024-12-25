package com.storynest.sn_post_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SnPostServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnPostServiceApplication.class, args);
	}

}

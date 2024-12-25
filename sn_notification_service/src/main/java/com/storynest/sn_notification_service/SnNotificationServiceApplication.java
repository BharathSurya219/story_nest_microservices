package com.storynest.sn_notification_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SnNotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnNotificationServiceApplication.class, args);
	}

}

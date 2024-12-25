package com.storynest.sn_customer_service.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMappingConfig {

	@Bean
	public ModelMapper modelMap() {
		return new ModelMapper();
	}
}

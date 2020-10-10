package com.joenpaco.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.joenpaco.models.dtos.Product;
import com.joenpaco.utils.Util;

@Configuration
public class AppConfig {
	
	@Bean
	public Product product() {
		return new Product();
	}
	
	@Bean
	public Util util() {
		return new Util();
	}

}

package com.test.banco.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfigCors implements WebMvcConfigurer{
	
	public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/")
				
				.allowedOrigins("http://localhost:4200")
				.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD");
	}

}

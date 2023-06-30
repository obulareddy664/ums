package com.ums.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"dev","qa"})
public class UserConfig {

	@Value("${spring.datasource.url}")
	private String message;
	

	public String getMessage() {
		return message;
	}
}

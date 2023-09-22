package com.citihive.payvote.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	 @Bean
	 public RestTemplate restTemplate() {
	        return new RestTemplate();
	 }
    @Value("${base.api.url}")
    private String BASE_API_URL = null ;

    @Value("${api.key}")
    private String API_KEY = null;

    public String getBASE_API_URL() {
        return BASE_API_URL;
    }

    public String getAPI_KEY() {
        return API_KEY;
    }
}

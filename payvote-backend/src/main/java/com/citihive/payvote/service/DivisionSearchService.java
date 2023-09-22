package com.citihive.payvote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.citihive.payvote.config.AppConfig;

@Service
public class DivisionSearchService {
	
	@Autowired
    private AppConfig appConfig;

    private final RestTemplate restTemplate;

    public DivisionSearchService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String divisionSearch(String query) {
    	   // Access the static final values from AppConfig
        String baseUrl = appConfig.getBASE_API_URL();
        String apiKey = appConfig.getAPI_KEY();
        
        String url = baseUrl + "divisions?key=" + apiKey + "&query=" + query;
        return restTemplate.getForObject(url, String.class);
    }
}

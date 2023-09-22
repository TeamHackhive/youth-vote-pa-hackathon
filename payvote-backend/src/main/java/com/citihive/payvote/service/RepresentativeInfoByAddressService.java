package com.citihive.payvote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.citihive.payvote.config.AppConfig;

@Service
public class RepresentativeInfoByAddressService {

	@Autowired
    private AppConfig appConfig;
   
    private final RestTemplate restTemplate;

    public RepresentativeInfoByAddressService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getRepresentativeInfoByAddress(String address) {
    	 String baseUrl = appConfig.getBASE_API_URL();
         String apiKey = appConfig.getAPI_KEY();
        String url = baseUrl + "representatives?key=" + apiKey + "&address=" + address;
        return restTemplate.getForObject(url, String.class);
    }
}

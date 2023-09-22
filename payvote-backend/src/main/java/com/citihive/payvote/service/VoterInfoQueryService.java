package com.citihive.payvote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.citihive.payvote.config.AppConfig;

@Service
public class VoterInfoQueryService {

	 @Autowired
	 private AppConfig appConfig;

    private final RestTemplate restTemplate;

    public VoterInfoQueryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getVoterInfo(String address, String electionId) {
    	String baseUrl = appConfig.getBASE_API_URL();
        String apiKey = appConfig.getAPI_KEY();
        String url = baseUrl + "voterinfo?key=" + apiKey + "&address=" + address + "&electionId=" + electionId;
        return restTemplate.getForObject(url, String.class);
    }
}

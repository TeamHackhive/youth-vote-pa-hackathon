package com.citihive.payvote.controller;

import com.citihive.payvote.service.ElectionQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ElectionQueryController {

    @Autowired
    private ElectionQueryService electionQueryService;

    @GetMapping("/elections")
    public String getElections() {
        return electionQueryService.getElections();
    }
}

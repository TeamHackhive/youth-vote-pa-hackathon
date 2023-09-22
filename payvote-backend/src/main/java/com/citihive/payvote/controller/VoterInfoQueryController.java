package com.citihive.payvote.controller;

import com.citihive.payvote.service.VoterInfoQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class VoterInfoQueryController {

    @Autowired
    private VoterInfoQueryService voterInfoQueryService;

    @GetMapping("/voterinfo")
    public String getVoterInfo(@RequestParam String address, @RequestParam String electionId) {
        return voterInfoQueryService.getVoterInfo(address, electionId);
    }
}

package com.citihive.payvote.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.citihive.payvote.service.RepresentativeInfoByAddressService;

@RestController
public class RepresentativeInfoByAddressController {

    @Autowired
    private RepresentativeInfoByAddressService representativeInfoByAddressService;

    @GetMapping("/representatives/address")
    public String getRepresentativeInfoByAddress(@RequestParam String address) {
        return representativeInfoByAddressService.getRepresentativeInfoByAddress(address);
    }
}

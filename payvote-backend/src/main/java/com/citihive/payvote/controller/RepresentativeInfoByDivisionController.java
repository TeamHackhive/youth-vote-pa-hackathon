package com.citihive.payvote.controller;

import com.citihive.payvote.service.RepresentativeInfoByDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class RepresentativeInfoByDivisionController {

    @Autowired
    private RepresentativeInfoByDivisionService representativeInfoByDivisionService;

    @GetMapping("/representatives/division/{divisionId}")
    public String getRepresentativeInfoByDivision(@PathVariable String divisionId) {
        return representativeInfoByDivisionService.getRepresentativeInfoByDivision(divisionId);
    }
}

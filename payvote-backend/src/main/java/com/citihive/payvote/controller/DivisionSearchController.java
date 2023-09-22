package com.citihive.payvote.controller;

import com.citihive.payvote.service.DivisionSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class DivisionSearchController {

    @Autowired
    private DivisionSearchService divisionSearchService;

    @GetMapping("/division/search")
    public String divisionSearch(@RequestParam String query) {
        return divisionSearchService.divisionSearch(query);
    }
}

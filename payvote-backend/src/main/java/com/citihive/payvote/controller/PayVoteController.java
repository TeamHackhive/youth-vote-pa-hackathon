package com.citihive.payvote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PayVoteController {

    @GetMapping("/home")
    public String home(Model model){
        return "index.html";
    }

    @GetMapping("/about")
    public String about(){
        return "about.html";
    }

    @GetMapping("/contacts")
    public String contacts(){
        return "contacts.html";
    }
}

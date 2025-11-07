package com.example.quizapp.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/quizapp")
public class basic {

    @GetMapping("/hi")   
    public String hello(){
        return "welcome to application";
    }
}

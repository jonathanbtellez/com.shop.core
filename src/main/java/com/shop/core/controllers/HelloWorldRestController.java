package com.shop.core.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {

    @GetMapping("/greet/{userName}")
    public String greet(@PathVariable String userName){
        System.out.println("Execute greet method");
        return "Hello world " + userName;
    }
}

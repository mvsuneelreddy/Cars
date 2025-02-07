package com.example.Ecom.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Main {

    @GetMapping("hello")
    public String hello(){
        return "Hello World";
    }
    @GetMapping("work")
    public String work(){
        return "This is working fine go ahead";
    }
}

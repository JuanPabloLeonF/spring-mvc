package com.spring.springsecurityjwt.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller")
@RequiredArgsConstructor
public class Controller {

    @GetMapping("/hello")
    public String getHello() {
        return "Hola mundo";
    }

    @GetMapping("/protectedhello")
    public String getHelloProtected() {
        return "Hola mundo pero soy uno protegido";
    }
}

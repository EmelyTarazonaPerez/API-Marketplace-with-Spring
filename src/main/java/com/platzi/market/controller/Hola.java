package com.platzi.market.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludar")
public class Hola {

    @GetMapping("/hola")
    public  String saludar () {
        return "Nunca pares de aprender :D";

    }
}

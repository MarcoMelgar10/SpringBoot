package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {


    @GetMapping(path = "/hello/{nombre}")
    public String HelloWord(@PathVariable String nombre){
        return "Hello "  + nombre;
    }
    @GetMapping(path = "/loop2")
    public int [] AmmountWords(){
       int [] ammount = new int[10];
        for (int i = 0; i < ammount.length; i++) {
            ammount[i] = i;
        }
        return ammount;
    }

}

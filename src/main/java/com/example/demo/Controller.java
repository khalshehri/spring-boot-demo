package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/api/demo")
    public ResponseEntity demo(){
        return ResponseEntity.ok("API Demo");
    }

    @GetMapping
    public ResponseEntity test2(){
        return ResponseEntity.ok("Home");
    }

}

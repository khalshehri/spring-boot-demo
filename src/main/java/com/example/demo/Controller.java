package com.example.demo;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

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

    @GetMapping("/api/download")
    public HttpEntity<byte[]> download() throws Exception {


        ClassPathResource file = new ClassPathResource("test.pdf");

        // Now creating byte array of same length as file
        byte[] arr = file.getInputStream().readAllBytes();

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_PDF);
        header.set(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=test.pdf");
        header.setContentLength(arr.length);

        return new HttpEntity<byte[]>(arr, header);


    }

}

package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
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
        return ResponseEntity.ok("API Demo server port : ");
    }

    @GetMapping
    public ResponseEntity test2(){
        return ResponseEntity.ok("Home");
    }

    @GetMapping("/api/mb/download")
    public HttpEntity<byte[]> downloadMB() throws Exception {


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

    @GetMapping("/api/kb/download")
    public HttpEntity<byte[]> downloadKB() throws Exception {


        ClassPathResource file = new ClassPathResource("test28kb.pdf");

        // Now creating byte array of same length as file
        byte[] arr = file.getInputStream().readAllBytes();

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_PDF);
        header.set(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=test28kb.pdf");
        header.setContentLength(arr.length);

        return new HttpEntity<byte[]>(arr, header);


    }

}

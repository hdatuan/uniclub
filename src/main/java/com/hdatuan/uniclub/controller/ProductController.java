package com.hdatuan.uniclub.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {


    @PostMapping
    public ResponseEntity<?> addProduct(){

        return ResponseEntity.ok("add Product");
    }

}

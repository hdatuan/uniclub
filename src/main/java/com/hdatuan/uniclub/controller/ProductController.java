package com.hdatuan.uniclub.controller;


import com.hdatuan.uniclub.request.InsertProductRequest;
import com.hdatuan.uniclub.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<?> addProduct(InsertProductRequest request) {
        productService.insertProduct(request);
        return ResponseEntity.ok("add Product");
    }

}

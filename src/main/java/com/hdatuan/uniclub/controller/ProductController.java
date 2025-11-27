package com.hdatuan.uniclub.controller;


import com.hdatuan.uniclub.request.InsertProductRequest;
import com.hdatuan.uniclub.response.BaseResponse;
import com.hdatuan.uniclub.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
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

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(HttpStatus.OK.value());
        baseResponse.setMessage("Successfully get all products");
        baseResponse.setData(productService.getAllProduct());
        return ResponseEntity.ok(baseResponse);
    }
}

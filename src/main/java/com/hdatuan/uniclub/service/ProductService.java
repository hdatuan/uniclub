package com.hdatuan.uniclub.service;

import com.hdatuan.uniclub.dto.ProductDTO;
import com.hdatuan.uniclub.request.InsertProductRequest;

import java.util.List;

public interface ProductService {

    void insertProduct(InsertProductRequest request);

    List<ProductDTO> getAllProduct();
}

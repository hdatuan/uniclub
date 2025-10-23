package com.hdatuan.uniclub.service.imp;

import com.hdatuan.uniclub.request.InsertProductRequest;
import com.hdatuan.uniclub.service.FileService;
import com.hdatuan.uniclub.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private FileService fileService;

    @Override
    public void insertProduct(InsertProductRequest request){
        fileService.save(request.getFile());
    }

}

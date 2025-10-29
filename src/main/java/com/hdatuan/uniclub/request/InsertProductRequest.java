package com.hdatuan.uniclub.request;


import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class InsertProductRequest {
    MultipartFile file;
    String name;
    String description;
    double price;
    int idSize;
    int idColor;
    int quantity;
}

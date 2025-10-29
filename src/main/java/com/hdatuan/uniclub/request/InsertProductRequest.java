package com.hdatuan.uniclub.request;


import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class InsertProductRequest {
    private MultipartFile file;
    private String name;
    private String description;
    private double price;
    private int idSize;
    private int idColor;
    private int quantity;
}

package com.hdatuan.uniclub.request;


import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class InsertProductRequest {
    MultipartFile file;
}

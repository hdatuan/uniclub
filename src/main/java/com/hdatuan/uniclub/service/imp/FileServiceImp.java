package com.hdatuan.uniclub.service.imp;


import com.hdatuan.uniclub.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileServiceImp implements FileService {

    @Value("${upload.image}")
    private String root;

    @Override
    public void save(MultipartFile file){

        try {
            Path rootPath = Paths.get(root);
            if ( !Files.exists(rootPath)) {
                Files.createDirectories(rootPath);
            }
            Files.copy( file.getInputStream() , rootPath.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        } catch ( Exception e) {
            System.out.println(e.getMessage());
        }

    }


    @Override
    public Resource load(String filename){
        try {
            Path filePath = Paths.get(root).resolve(filename);
            org.springframework.core.io.Resource resource = new UrlResource(filePath.toUri());
            if ( resource.exists() ){
                return resource;
            } else {
                throw new RuntimeException(filename);
            }
        }
        catch ( Exception e) {
            throw new RuntimeException(e);
        }
    }
}

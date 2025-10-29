package com.hdatuan.uniclub.service.imp;

import com.hdatuan.uniclub.entity.Color;
import com.hdatuan.uniclub.entity.Product;
import com.hdatuan.uniclub.entity.Size;
import com.hdatuan.uniclub.entity.Variant;
import com.hdatuan.uniclub.exceptions.InsertUpdateException;
import com.hdatuan.uniclub.repository.ProductRepository;
import com.hdatuan.uniclub.repository.VariantRepository;
import com.hdatuan.uniclub.request.InsertProductRequest;
import com.hdatuan.uniclub.service.FileService;
import com.hdatuan.uniclub.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private FileService fileService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private VariantRepository variantRepository;

    @Transactional
    @Override
    public void insertProduct(InsertProductRequest request){
        try {
            fileService.save(request.getFile());

            Product product = new Product();
            product.setName(request.getName());
            product.setDescription(request.getDescription());
            product.setPrice(request.getPrice());

            Product insertProduct = productRepository.save(product);

            Variant variant = new Variant();
            variant.setProduct(insertProduct);

            Color color = new Color();
            color.setId(request.getIdColor());
            variant.setColor(color);

            Size size = new Size();
            size.setId(request.getIdSize());
            variant.setSize(size);

            variantRepository.save(variant);
        } catch (Exception e){
            System.out.println("Error : " + e.getMessage());
            throw new InsertUpdateException(e.getMessage());
        }
    }

}

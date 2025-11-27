package com.hdatuan.uniclub.mapper;

import com.hdatuan.uniclub.dto.ProductDTO;
import com.hdatuan.uniclub.entity.Product;

import java.math.BigDecimal;

public class ProductMapper {

    public static ProductDTO toProductDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(BigDecimal.valueOf(product.getPrice()));
        productDTO.setImage(
                product.getVariants().stream()
                .findFirst()
                .map(item -> item.getImages().split(","))
                .orElse(new String[]{"default.png"})
        );
        return productDTO;
    }



}

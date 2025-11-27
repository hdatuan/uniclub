package com.hdatuan.uniclub.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
public class ProductDTO {
    private int id;
    private String name;
    private BigDecimal price;
    private String[] image;
}

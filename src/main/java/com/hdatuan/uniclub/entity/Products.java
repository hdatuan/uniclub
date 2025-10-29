package com.hdatuan.uniclub.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name="products")
@Getter
@Setter
public class Products {

    @Id
    private int id;
    private String name;
    private String description;
    private String information;
    private double price;
    private int idBrand;
    private LocalDateTime createdDate;


}

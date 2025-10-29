package com.hdatuan.uniclub.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name="product")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String information;
    private double price;

    @ManyToOne
    @JoinColumn(name="id_brand")
    private Brand brand;

    private LocalDateTime createDate;


}

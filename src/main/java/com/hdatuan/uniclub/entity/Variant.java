package com.hdatuan.uniclub.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="variant")
public class Variant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sku;

    @ManyToOne
    @JoinColumn(name="id_product")
    private Product product;

    @ManyToOne
    @JoinColumn(name="id_color")
    private Color color;

    @ManyToOne
    @JoinColumn(name="id_size")
    private Size size;

    private String images;
    private int quantity;

}

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
    private Product idProduct;

    @ManyToOne
    @JoinColumn(name="id_color")
    private Color idColor;

    @ManyToOne
    @JoinColumn(name="id_size")
    private Size idSize;

    private String images;
    private int quantity;

}

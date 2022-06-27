package com.example.trainingproject.Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private int id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_size")
    private double size;

    @Column(name = "price")
    private double price;


}
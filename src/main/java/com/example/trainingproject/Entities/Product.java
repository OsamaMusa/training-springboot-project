package com.example.trainingproject.Entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Entity
@Table
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;

    @Column(name = "product_name",nullable = false)
    @NotNull
    @Size(min = 5,max = 20)
    private String productName;

    @Column(name = "price")
    @NotNull
    @Min(1)
    @Max(200)
    private double price;


}

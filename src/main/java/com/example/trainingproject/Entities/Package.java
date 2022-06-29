package com.example.trainingproject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table
public class Package implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "package_id")
    private int id;

    @Column(name = "package_size" , nullable = false)
    @NotNull
    @Min(value = 1)
    @Max(value = 5)
    private double size;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;


    @ManyToMany
    @JoinTable(
            name = "package_products",
            joinColumns = @JoinColumn(name = "package_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    List<Product> products;

}

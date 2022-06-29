package com.example.trainingproject.Entities;

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


    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    @OneToMany(fetch=FetchType.LAZY, mappedBy= "packages")
    private List<Product> products;
}

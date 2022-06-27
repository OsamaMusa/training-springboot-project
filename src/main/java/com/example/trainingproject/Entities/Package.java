package com.example.trainingproject.Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "package_id")
    private int id;

    @Column(name = "package_size")
    private double size;

    @Column(name ="deleverd")
    private boolean isDelevered;



}

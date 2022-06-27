package com.example.trainingproject.Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "car_id")
    private int id;

    @Column(name = "car_size")
    private double size;

    @Column(name ="full_name")
    private String fullName;



}

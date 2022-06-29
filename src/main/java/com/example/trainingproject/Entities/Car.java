package com.example.trainingproject.Entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Data
@Entity
@Table
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private int id;

    @Column(name = "car_size" ,nullable = false)
    @NotNull
    @Min(value = 2)
    @Max(value = 20)
    private double size;

    @Column(name ="full_name", nullable = false)
    @NotNull
    @Size(min = 5,max = 20)
    private String fullName;





}

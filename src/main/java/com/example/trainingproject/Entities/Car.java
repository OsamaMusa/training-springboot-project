package com.example.trainingproject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.List;

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

    @JsonIgnore
    @OneToMany(fetch=FetchType.LAZY, mappedBy= "car")
    private List<Order> order;

    @ManyToOne
    @JoinColumn(name="driver_id")
    private Driver driver;



}

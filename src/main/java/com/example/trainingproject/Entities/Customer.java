package com.example.trainingproject.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;

    @Column(nullable = false , name = "full_name")
    private String fullName;

    @Column(nullable = false,name = "location")
    private String location;

    @Column(nullable = false , name="phone")
    private String phone;

}

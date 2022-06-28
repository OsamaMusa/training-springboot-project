package com.example.trainingproject.Entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Data
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;

    @Column(nullable = false , name = "full_name")
    private String fullName;

    @Column(nullable = false,name = "address")
    private String location;

    @Column(nullable = false , name="phone")
    private String phone;

}

package com.example.trainingproject.Entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @NotNull
    @Size(min = 5,max = 20)
    private String fullName;

    @Column(nullable = false,name = "address")
    @NotNull
    @Size(min = 5,max = 20)
    private String location;

    @Column(nullable = false , name="phone")
    @NotNull
    @Size(min = 5,max = 20)
    private String phone;

}

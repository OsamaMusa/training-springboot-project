package com.example.trainingproject.Entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table
@Data
public class Driver implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id")
    private int id;

    @Column(nullable = false , name = "full_name")
    private String fullName;

    @Column(nullable = false,name = "location")
    private String location;

    @Column(nullable = false , name="phone")
    private String phone;

    @Column(nullable = false , name="email")
    private String email;

    @Column(nullable = false , name="dob")
    private Date dob;



}

package com.example.trainingproject.Entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table
@Data
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

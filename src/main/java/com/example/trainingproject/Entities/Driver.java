package com.example.trainingproject.Entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table
@Data
public class Driver implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id")
    private int id;

    @Column(nullable = false , name = "full_name")
    @NotNull
    @Size(min = 5,max = 20)
    private String fullName;

    @Column(nullable = false,name = "location")
    @NotNull
    @Size(min = 5,max = 20)
    private String location;

    @Column(nullable = false , name="phone")
    @NotNull
    @Size(min = 5,max = 20)
    @Pattern(regexp = "^\\d{3}[- .]?\\d{3}[- .]?\\d{4}$")
    private String phone;

    @Column(nullable = false , name="email")
    @NotNull
    @Size(min = 5,max = 20)
    private String email;

    @Column(nullable = false , name="dob")
    @NotNull
    @Past
    private Date dob;

    @OneToMany(fetch=FetchType.LAZY, mappedBy= "driver")
    private List<Car> cars;

}

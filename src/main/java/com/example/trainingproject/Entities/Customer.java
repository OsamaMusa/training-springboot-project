package com.example.trainingproject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

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
    @Pattern(regexp = "^\\d{3}[- .]?\\d{3}[- .]?\\d{4}$")
    private String phone;

    @JsonIgnore
    @OneToMany(fetch=FetchType.LAZY, mappedBy= "customer")
    private List<Order> order;

}

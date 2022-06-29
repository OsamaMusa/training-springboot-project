package com.example.trainingproject.Entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity(name = "orders")
@Table
@Data
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;

    @Column(name ="deleverd", nullable = false)
    @NotNull
    private boolean isDelevered;

    @Column(name ="deleverd_date", nullable = false)
    @NotNull
    private Date deleveredDate;

    @Column(name ="receved", nullable = false)
    @NotNull
    private boolean isReceved;

    @Column(name ="receved_date", nullable = false)
    @NotNull
    private Date recevedDate;

    @OneToMany(fetch=FetchType.LAZY, mappedBy= "order")
    private List<Package> packages;

    @ManyToOne
    @JoinColumn(name="car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;
}

package com.example.trainingproject.Repositories;

import com.example.trainingproject.Entities.Order;
import com.example.trainingproject.Entities.Package;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order,Integer> {
}

package com.example.trainingproject.IRepositories;

import com.example.trainingproject.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order,Integer> {
}

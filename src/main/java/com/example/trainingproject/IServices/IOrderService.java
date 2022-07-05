package com.example.trainingproject.IServices;

import com.example.trainingproject.Entities.Order;

import java.util.List;

public interface IOrderService {
    Order insert(Order order);

    Order findById(int id);

    List<Order> getAll();

    boolean delete(int id);

    Order update(int id, Order order);
}

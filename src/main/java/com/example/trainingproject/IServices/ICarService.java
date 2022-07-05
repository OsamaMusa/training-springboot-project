package com.example.trainingproject.IServices;

import com.example.trainingproject.Entities.Car;

import java.util.List;

public interface ICarService {
    Car insert(Car car);

    Car findById(int id);

    List<Car> findByName(String fullName);

    List<Car> getAll();

    boolean delete(int id);

    Car update(int id, Car car);
}

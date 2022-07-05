package com.example.trainingproject.IServices;

import com.example.trainingproject.Entities.Driver;

import java.util.List;

public interface IDriverService {
    Driver insert(Driver driver);

    Driver findById(int id);

    List<Driver> findByName(String fullName);

    List<Driver> getAll();

    boolean delete(int id);

    Driver update(int id, Driver driver);
}

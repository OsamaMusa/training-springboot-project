package com.example.trainingproject.Repositories;

import com.example.trainingproject.Entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICarRepository extends JpaRepository<Car, Integer> {


    List<Car> findCarByFullName(String fullName);
}

package com.example.trainingproject.Services;

import com.example.trainingproject.Entities.Car;
import com.example.trainingproject.Repositories.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private ICarRepository carRepository;

    public Car addCar(Car car) {
        carRepository.save(car);
        return car;
    }

    public Car findCarById(int id) {

        Car car =  carRepository.findById(id).orElse(null);
        if(car != null){
            return  car;
        }
        return null;

    }

    public List<Car> findCarByName(String fullName) {
        List<Car> cars =  carRepository.findCarByFullName(fullName);
        if(cars != null ){
            return  cars;
        }
        return null;

    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public boolean deleteCar(int id) {
        Car existedCar =  carRepository.findById(id).orElse(null);
        if(existedCar != null ){
            carRepository.delete(existedCar);
            return  true;
        }
        return false;

    }

    public Car updateCar(int id , Car car) {
        Car existedCar =  carRepository.findById(id).orElse(null);
        if(existedCar != null && car != null){
            return  carRepository.save(car);
        }
        return null;

    }
}

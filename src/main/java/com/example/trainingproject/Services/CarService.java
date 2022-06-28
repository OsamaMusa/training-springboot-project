package com.example.trainingproject.Services;

import com.example.trainingproject.Entities.Car;
import com.example.trainingproject.Repositories.ICarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService  {

    @Autowired
    private ICarRepository CarRepository;
    Logger logger = LoggerFactory.getLogger(CarService.class);

    public Car addCar(Car Car) {
        Car res = CarRepository.save(Car);
        logger.info("Inserted Car : "+ res.toString());
        return res;
    }

    public Car findCarById(int id) {

        Car res =  CarRepository.findById(id).orElse(null);
        if(res != null){
            logger.info("Existed Car : "+ res.toString());
            return  res;
        }
        logger.info("Car Id : "+ id+" not found !");
        return null;

    }

    public List<Car> findCarByName(String fullName) {
        List<Car> Cars =  CarRepository.findCarByFullName(fullName);
        if(Cars != null ){
            logger.info("Existed Car : "+ Cars.toString());
            return  Cars;
        }
        logger.info("Car Name : "+ fullName +" not found !");
        return null;

    }

    public List<Car> getAllCars() {
        List<Car> res = CarRepository.findAll();
        logger.info("Receved "+res.size() +" Car : ");
        return res;
    }

    public boolean deleteCar(int id) {
        Car Car =  CarRepository.findById(id).orElse(null);
        if(Car != null ){
            logger.info("Deleted Car : "+ Car.toString());
            CarRepository.delete(Car);
            return  true;
        }
        logger.info("Car Id : "+ id+" not found !");
        return false;

    }

    public Car updateCar(int id , Car Car) {
        Car foundedCar =  CarRepository.findById(id).orElse(null);
        if(foundedCar != null && Car != null){
            logger.info("Updated Car : "+ Car.toString());
            return  CarRepository.save(Car);
        }
        logger.info("Car Id : "+ id+" not found !");
        return null;

    }
}

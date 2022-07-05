package com.example.trainingproject.Services;

import com.example.trainingproject.CustomExeptions.MyResourceNotFoundException;
import com.example.trainingproject.Entities.Car;
import com.example.trainingproject.IServices.ICarService;
import com.example.trainingproject.Repositories.ICarRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CarService implements ICarService {

    @Autowired
    private ICarRepository CarRepository;
    @Autowired
    private LoggerService loggerService;
    Logger logger = loggerService.logger;

    @Override
    public Car insert(Car car) {
        if(car == null)
            throw  new MyResourceNotFoundException("Can't insert null as Car object");
        Car res = CarRepository.save(car);
        logger.info("Inserted Car : "+ res.toString());
        return res;
    }

    @Override
    public Car findById(int id) {

        Optional<Car> res =  CarRepository.findById(id);
        if(res.isPresent()){
            logger.info("Existed Car : "+ res.toString());
            return  res.get();
        }
        logger.info("Car Id : "+ id+" not found !");
        throw new MyResourceNotFoundException("there is no cars to display");

    }

    @Override
    public List<Car> findByName(String fullName) {
        List<Car> Cars =  CarRepository.findCarByFullName(fullName);
        if(Cars != null ){
            logger.info("Existed Car : "+ Cars.toString());
            return  Cars;
        }
        logger.info("Car Name : "+ fullName +" not found !");
        throw new MyResourceNotFoundException("there is no cars to display");

    }

    @Override
    public List<Car> getAll() {
        List<Car> res = CarRepository.findAll();
        logger.info("Receved "+res.size() +" Car : ");
        if(res.size() > 0 )
          return res;
        throw new MyResourceNotFoundException("there is no cars to display");
    }

    @Override
    public boolean delete(int id) {
        Optional<Car> car =  CarRepository.findById(id);
        if(car.isPresent() ){
            logger.info("Deleted Car : "+ car.get().toString());
            CarRepository.delete(car.get());
            return  true;
        }
        logger.info("Car Id : "+ id+" not found !");
        throw new MyResourceNotFoundException("there is no cars to delete ");

    }

    @Override
    public Car update(int id, Car car) {
        if(car == null)
            throw new MyResourceNotFoundException("Can't update null as Car object");

        Optional<Car> foundedCar =  CarRepository.findById(id);
        if(foundedCar.isPresent() ){
            logger.info("Updated Car : "+ car.toString());
            return  CarRepository.save(car);
        }

        logger.info("Car Id : "+ id +" not found !");
        throw new MyResourceNotFoundException("there is no cars to update ");

    }
}

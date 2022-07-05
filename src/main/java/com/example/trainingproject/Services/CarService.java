package com.example.trainingproject.Services;

import com.example.trainingproject.CustomExeptions.MyResourceNotFoundException;
import com.example.trainingproject.Entities.Car;
import com.example.trainingproject.IServices.ICarService;
import com.example.trainingproject.IRepositories.ICarRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService implements ICarService {

    @Autowired
    private ICarRepository carRepository;
    @Autowired
    private LoggerService loggerService;
    Logger logger = loggerService.logger;

    @Override
    public Car insert(Car car) {
        if(car == null)
            throw  new MyResourceNotFoundException("Can't insert null as Car object");
        Car res = carRepository.save(car);
        logger.info("Inserted Car : "+ res.toString());
        return res;
    }

    @Override
    public Car findById(int id) {

        Optional<Car> res =  carRepository.findById(id);
        if(res.isPresent()){
            logger.info("Existed Car : "+ res.toString());
            return  res.get();
        }
        logger.info("Car Id : "+ id+" not found !");
        throw new MyResourceNotFoundException("there is no cars to display");

    }

    @Override
    public List<Car> findByName(String fullName) {
        List<Car> Cars =  carRepository.findCarByFullName(fullName);
        if(Cars != null ){
            logger.info("Existed Car : "+ Cars.toString());
            return  Cars;
        }
        logger.info("Car Name : "+ fullName +" not found !");
        throw new MyResourceNotFoundException("there is no cars to display");

    }

    @Override
    public List<Car> getAll() {
        List<Car> res = carRepository.findAll();
        logger.info("Receved "+res.size() +" Car : ");
        if(res.size() > 0 )
          return res;
        throw new MyResourceNotFoundException("there is no cars to display");
    }

    @Override
    public boolean delete(int id) {
        Optional<Car> car =  carRepository.findById(id);
        if(car.isPresent() ){
            logger.info("Deleted Car : "+ car.get().toString());
            carRepository.delete(car.get());
            return  true;
        }
        logger.info("Car Id : "+ id+" not found !");
        throw new MyResourceNotFoundException("there is no cars to delete ");

    }

    @Override
    public Car update(int id, Car car) {
        if(car == null)
            throw new MyResourceNotFoundException("Can't update null as Car object");

        Optional<Car> foundedCar =  carRepository.findById(id);
        if(foundedCar.isPresent() ){
            logger.info("Updated Car : "+ car.toString());
            return  carRepository.save(car);
        }

        logger.info("Car Id : "+ id +" not found !");
        throw new MyResourceNotFoundException("there is no cars to update ");

    }
}

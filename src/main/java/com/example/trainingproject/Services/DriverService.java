package com.example.trainingproject.Services;

import com.example.trainingproject.Entities.Driver;
import com.example.trainingproject.IServices.IDriverService;
import com.example.trainingproject.Repositories.IDriverRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService implements IDriverService {

    @Autowired
    private IDriverRepository DriverRepository;
    @Autowired
    private LoggerService loggerService;
    Logger logger = loggerService.logger;

    @Override
    public Driver insert(Driver driver) {
        Driver res = DriverRepository.save(driver);
        logger.info("Inserted Driver : "+ res.toString());
        return res;
    }

    @Override
    public Driver findById(int id) {

        Optional<Driver> res =  DriverRepository.findById(id);
        if(res.isPresent()){
            logger.info("Existed Driver : "+ res.get().toString());
            return  res.get();
        }
        logger.info("Driver Id : "+ id+" not found !");
        return null;

    }

    @Override
    public List<Driver> findByName(String fullName) {
        List<Driver> drivers =  DriverRepository.findDriverByFullName(fullName);
        if(drivers != null ){
            logger.info("Existed Driver : "+ drivers.toString());
            return  drivers;
        }
        logger.info("Driver Name : "+ fullName +" not found !");
        return null;

    }

    @Override
    public List<Driver> getAll() {
        List<Driver> res = DriverRepository.findAll();
        logger.info("Receved "+res.size() +" Driver : ");
        return res;
    }

    @Override
    public boolean delete(int id) {
        Optional<Driver> driver =  DriverRepository.findById(id);
        if(driver.isPresent() ){
            logger.info("Deleted Driver : "+ driver.get().toString());
            DriverRepository.delete(driver.get());
            return  true;
        }
        logger.info("Driver Id : "+ id+" not found !");
        return false;

    }

    @Override
    public Driver update(int id, Driver driver) {
        Optional<Driver> foundedDriver =  DriverRepository.findById(id);
        if(foundedDriver.isPresent()  && driver != null){
            logger.info("Updated Driver : "+ driver.toString());
            return  DriverRepository.save(driver);
        }
        logger.info("Driver Id : "+ id+" not found !");
        return null;

    }
}

package com.example.trainingproject.Services;

import com.example.trainingproject.Entities.Driver;
import com.example.trainingproject.Repositories.IDriverRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService  {

    @Autowired
    private IDriverRepository DriverRepository;
    Logger logger = LoggerFactory.getLogger(DriverService.class);

    public Driver addDriver(Driver Driver) {
        Driver res = DriverRepository.save(Driver);
        logger.info("Inserted Driver : "+ res.toString());
        return res;
    }

    public Driver findDriverById(int id) {

        Driver res =  DriverRepository.findById(id).orElse(null);
        if(res != null){
            logger.info("Existed Driver : "+ res.toString());
            return  res;
        }
        logger.info("Driver Id : "+ id+" not found !");
        return null;

    }

    public List<Driver> findDriverByName(String fullName) {
        List<Driver> Drivers =  DriverRepository.findDriverByFullName(fullName);
        if(Drivers != null ){
            logger.info("Existed Driver : "+ Drivers.toString());
            return  Drivers;
        }
        logger.info("Driver Name : "+ fullName +" not found !");
        return null;

    }

    public List<Driver> getAllDrivers() {
        List<Driver> res = DriverRepository.findAll();
        logger.info("Receved "+res.size() +" Driver : ");
        return res;
    }

    public boolean deleteDriver(int id) {
        Driver Driver =  DriverRepository.findById(id).orElse(null);
        if(Driver != null ){
            logger.info("Deleted Driver : "+ Driver.toString());
            DriverRepository.delete(Driver);
            return  true;
        }
        logger.info("Driver Id : "+ id+" not found !");
        return false;

    }

    public Driver updateDriver(int id , Driver Driver) {
        Driver foundedDriver =  DriverRepository.findById(id).orElse(null);
        if(foundedDriver != null && Driver != null){
            logger.info("Updated Driver : "+ Driver.toString());
            return  DriverRepository.save(Driver);
        }
        logger.info("Driver Id : "+ id+" not found !");
        return null;

    }
}

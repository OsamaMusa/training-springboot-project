package com.example.trainingproject.Services;

import com.example.trainingproject.Entities.Driver;
import com.example.trainingproject.Repositories.IDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    @Autowired
    private IDriverRepository DriverRepository;

    public Driver addDriver(Driver Driver) {
        DriverRepository.save(Driver);
        return Driver;
    }

    public Driver findDriverById(int id) {

        Driver Driver =  DriverRepository.findById(id).orElse(null);
        if(Driver != null){
            return  Driver;
        }
        return null;

    }

    public List<Driver> findDriverByName(String fullName) {
        List<Driver> Drivers =  DriverRepository.findDriverByFullName(fullName);
        if(Drivers != null ){
            return  Drivers;
        }
        return null;

    }

    public List<Driver> getAllDrivers() {
        return DriverRepository.findAll();
    }

    public boolean deleteDriver(int id) {
        Driver existedDriver =  DriverRepository.findById(id).orElse(null);
        if(existedDriver != null ){
            DriverRepository.delete(existedDriver);
            return  true;
        }
        return false;

    }

    public Driver updateDriver(int id , Driver driver) {
        Driver existedDriver =  DriverRepository.findById(id).orElse(null);
        if(existedDriver != null && driver != null){
            return  DriverRepository.save(driver);
        }
        return null;

    }
}

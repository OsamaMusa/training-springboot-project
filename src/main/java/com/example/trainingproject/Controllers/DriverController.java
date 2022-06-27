package com.example.trainingproject.Controllers;

import com.example.trainingproject.Entities.Driver;
import com.example.trainingproject.Services.CarService;
import com.example.trainingproject.Services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService DriverService ;

    @GetMapping
    public List<Driver> getAllDrivers(){
        return DriverService.getAllDrivers();
    }
    @PostMapping
    public Driver addDriver(@RequestBody Driver Driver){
        return DriverService.addDriver(Driver);
    }
    @PutMapping("{id}")
    public Driver updateDriver(@PathVariable("id") int id,@RequestBody Driver Driver){
        return DriverService.updateDriver(id,Driver);
    }

    @GetMapping("{id}")
    public Driver findDriverById(@PathVariable("id") int id){
        return DriverService.findDriverById(id);
    }
    @DeleteMapping("{id}")
    public boolean deleteDriverById(@PathVariable("id") int id){
        return DriverService.deleteDriver(id);
    }
    @GetMapping("name/{name}")
    public List<Driver> findDriversByName(@PathVariable("name") String name){
        return DriverService.findDriverByName(name);
    }
}

package com.example.trainingproject.Controllers;

import com.example.trainingproject.Entities.Driver;
import com.example.trainingproject.Services.CarService;
import com.example.trainingproject.Services.DriverService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/driver")
@Tag(name = "Drivers" , description = "CRUD operation for driver entity")
public class DriverController {
    @Autowired
    private DriverService DriverService ;
    @GetMapping
    public List<Driver> getAllDrivers(){
        return DriverService.getAllDrivers();
    }
    @PostMapping
    public Driver addDriver(@Valid  @RequestBody Driver Driver){
        return DriverService.addDriver(Driver);
    }
    @PutMapping("{id}")
    public Driver updateDriver(@PathVariable("id") int id,@Valid @RequestBody Driver Driver){
        return DriverService.updateDriver(id,Driver);
    }

    @GetMapping("{id}")
    @Cacheable("${cache-name}")
    public Driver findDriverById(@PathVariable("id") int id){
        return DriverService.findDriverById(id);
    }
    @DeleteMapping("{id}")
    @CacheEvict("${cache-name}")
    public boolean deleteDriverById(@PathVariable("id") int id){
        return DriverService.deleteDriver(id);
    }
    @GetMapping("name/{name}")
    @Cacheable("${cache-name}")
    public List<Driver> findDriversByName(@PathVariable("name") String name){
        return DriverService.findDriverByName(name);
    }
}

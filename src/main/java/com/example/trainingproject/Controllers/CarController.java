package com.example.trainingproject.Controllers;

import com.example.trainingproject.Entities.Car;
import com.example.trainingproject.Services.CarService;
import com.example.trainingproject.Services.CarService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/car")
@Tag(name = "Cars" , description = "CRUD operation for car entity")
public class CarController {

    @Autowired
    private CarService CarService ;

    @GetMapping
    public List<Car> getAllCars(){
        return CarService.getAllCars();
    }
    @PostMapping
    public Car addCar(@Valid @RequestBody Car Car){
        return CarService.addCar(Car);
    }
    @PutMapping("{id}")
    public Car updateCar(@PathVariable("id") int id,@Valid @RequestBody Car Car){
        return CarService.updateCar(id,Car);
    }

    @GetMapping("{id}")
    @Cacheable("${cache-name}")
    public Car findCarById(@PathVariable("id") int id){
        return CarService.findCarById(id);
    }
    @DeleteMapping("{id}")
    @CacheEvict("${cache-name}")
    public boolean deleteCarById(@PathVariable("id") int id){
        return CarService.deleteCar(id);
    }
    @GetMapping("name/{name}")
    @Cacheable("${cache-name}")
    public List<Car> findCarsByName(@PathVariable("name") String name){
        return CarService.findCarByName(name);
    }
}

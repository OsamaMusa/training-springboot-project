package com.example.trainingproject.Controllers;

import com.example.trainingproject.Entities.Car;
import com.example.trainingproject.Services.CarService;
import com.example.trainingproject.Services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService CarService ;

    @GetMapping
    public List<Car> getAllCars(){
        return CarService.getAllCars();
    }
    @PostMapping
    public Car addCar(@RequestBody Car Car){
        return CarService.addCar(Car);
    }
    @PutMapping("{id}")
    public Car updateCar(@PathVariable("id") int id,@RequestBody Car Car){
        return CarService.updateCar(id,Car);
    }

    @GetMapping("{id}")
    public Car findCarById(@PathVariable("id") int id){
        return CarService.findCarById(id);
    }
    @DeleteMapping("{id}")
    public boolean deleteCarById(@PathVariable("id") int id){
        return CarService.deleteCar(id);
    }
    @GetMapping("name/{name}")
    public List<Car> findCarsByName(@PathVariable("name") String name){
        return CarService.findCarByName(name);
    }
}

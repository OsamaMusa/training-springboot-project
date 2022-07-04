package com.example.trainingproject.Controllers;

import com.example.trainingproject.Entities.Car;
import com.example.trainingproject.Services.CarService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/car")
@Tag(name = "Cars" , description = "CRUD operation for car entity")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> getAll(){
        return new ResponseEntity<List<Car>>( carService.getAll(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Car> insert(@Valid @RequestBody Car car){
        return new ResponseEntity<Car>(carService.insert(car), HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<Car> update(@PathVariable("id") int id,@Valid @RequestBody Car car){
        return new ResponseEntity<Car>(carService.update(id,car),HttpStatus.OK);
    }

    @GetMapping("{id}")
    @Cacheable("${cache-name}")
    public ResponseEntity<Car> findById(@PathVariable("id") int id){
        return new ResponseEntity<Car>(carService.findById(id),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    @CacheEvict("${cache-name}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") int id){
        return new ResponseEntity<Boolean>( carService.delete(id),HttpStatus.OK);
    }
    @GetMapping("name/{name}")
    @Cacheable("${cache-name}")
    public ResponseEntity<List<Car>> findByName(@PathVariable("name") String name){
        return  new ResponseEntity<List<Car>>( carService.findByName(name),HttpStatus.OK);
    }
}

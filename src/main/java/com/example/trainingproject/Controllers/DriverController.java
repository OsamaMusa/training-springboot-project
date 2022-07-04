package com.example.trainingproject.Controllers;

import com.example.trainingproject.Entities.Driver;
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
    private DriverService driverService;
    @GetMapping
    public List<Driver> getAll(){
        return driverService.getAll();
    }
    @PostMapping
    public Driver insert(@Valid  @RequestBody Driver Driver){
        return driverService.insert(Driver);
    }
    @PutMapping("{id}")
    public Driver update(@PathVariable("id") int id,@Valid @RequestBody Driver driver){
        return driverService.update(id,driver);
    }

    @GetMapping("{id}")
    @Cacheable("${cache-name}")
    public Driver findById(@PathVariable("id") int id){
        return driverService.findById(id);
    }
    @DeleteMapping("{id}")
    @CacheEvict("${cache-name}")
    public boolean deleteById(@PathVariable("id") int id){
        return driverService.delete(id);
    }
    @GetMapping("name/{name}")
    @Cacheable("${cache-name}")
    public List<Driver> findByName(@PathVariable("name") String name){
        return driverService.findByName(name);
    }
}

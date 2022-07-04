package com.example.trainingproject.Controllers;

import com.example.trainingproject.Entities.Package;
import com.example.trainingproject.Services.PackageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/package")
@Tag(name = "Packages" , description = "CRUD operation for package entity")
public class PackageController {

    @Autowired
    private PackageService packageService;
    @GetMapping
    public List<Package> getAll(){
        return packageService.getAll();
    }
    @PostMapping
    public Package insert(@Valid  @RequestBody Package Package){
        return packageService.insert(Package);
    }
    @PutMapping("{id}")
    public Package update(@PathVariable("id") int id,@Valid @RequestBody Package myPackage){
        return packageService.update(id,myPackage);
    }

    @GetMapping("{id}")
    @Cacheable("${cache-name}")
    public Package findById(@PathVariable("id") int id){
        return packageService.findById(id);
    }
    @DeleteMapping("{id}")
    @CacheEvict("${cache-name}")
    public boolean deleteById(@PathVariable("id") int id){
        return packageService.delete(id);
    }

}

package com.example.trainingproject.Controllers;

import com.example.trainingproject.Entities.Package;
import com.example.trainingproject.Services.CarService;
import com.example.trainingproject.Services.PackageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/package")
@Tag(name = "Packages" , description = "CRUD operation for package entity")
public class PackageController {

    @Autowired
    private PackageService PackageService ;
    @GetMapping
    public List<Package> getAllPackages(){
        return PackageService.getAllPackages();
    }
    @PostMapping
    public Package addPackage(@RequestBody Package Package){
        return PackageService.addPackage(Package);
    }
    @PutMapping("{id}")
    public Package updatePackage(@PathVariable("id") int id,@RequestBody Package Package){
        return PackageService.updatePackage(id,Package);
    }

    @GetMapping("{id}")
    @Cacheable("package-cache")
    public Package findPackageById(@PathVariable("id") int id){
        return PackageService.findPackageById(id);
    }
    @DeleteMapping("{id}")
    @CacheEvict("package-cache")
    public boolean deletePackageById(@PathVariable("id") int id){
        return PackageService.deletePackage(id);
    }

}

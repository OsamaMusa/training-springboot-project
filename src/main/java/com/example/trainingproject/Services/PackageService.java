package com.example.trainingproject.Services;

import com.example.trainingproject.Entities.Package;
import com.example.trainingproject.Repositories.IPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageService {

    @Autowired
    private IPackageRepository PackageRepository;

    public Package addPackage(Package Package) {
        PackageRepository.save(Package);
        return Package;
    }

    public Package findPackageById(int id) {

        Package Package =  PackageRepository.findById(id).orElse(null);
        if(Package != null){
            return  Package;
        }
        return null;

    }

    public List<Package> getAllPackages() {
        return PackageRepository.findAll();
    }

    public boolean deletePackage(int id) {
        Package existedPackage =  PackageRepository.findById(id).orElse(null);
        if(existedPackage != null ){
            PackageRepository.delete(existedPackage);
            return  true;
        }
        return false;

    }

    public Package updatePackage(int id , Package Package) {
        Package existedPackage =  PackageRepository.findById(id).orElse(null);
        if(existedPackage != null && Package != null){
            return  PackageRepository.save(Package);
        }
        return null;

    }
}

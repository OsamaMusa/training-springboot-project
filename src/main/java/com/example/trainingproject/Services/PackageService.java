package com.example.trainingproject.Services;

import com.example.trainingproject.Entities.Package;
import com.example.trainingproject.Repositories.IPackageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageService  {

    @Autowired
    private IPackageRepository PackageRepository;
    Logger logger = LoggerFactory.getLogger(PackageService.class);

    public Package addPackage(Package Package) {
        Package res = PackageRepository.save(Package);
        logger.info("Inserted Package : "+ res.toString());
        return res;
    }

    public Package findPackageById(int id) {

        Package res =  PackageRepository.findById(id).orElse(null);
        if(res != null){
            logger.info("Existed Package : "+ res.toString());
            return  res;
        }
        logger.info("Package Id : "+ id+" not found !");
        return null;

    }

    public List<Package> getAllPackages() {
        List<Package> res = PackageRepository.findAll();
        logger.info("Receved "+res.size() +" Package : ");
        return res;
    }

    public boolean deletePackage(int id) {
        Package Package =  PackageRepository.findById(id).orElse(null);
        if(Package != null ){
            logger.info("Deleted Package : "+ Package.toString());
            PackageRepository.delete(Package);
            return  true;
        }
        logger.info("Package Id : "+ id+" not found !");
        return false;

    }

    public Package updatePackage(int id , Package Package) {
        Package foundedPackage =  PackageRepository.findById(id).orElse(null);
        if(foundedPackage != null && Package != null){
            logger.info("Updated Package : "+ Package.toString());
            return  PackageRepository.save(Package);
        }
        logger.info("Package Id : "+ id+" not found !");
        return null;

    }
}

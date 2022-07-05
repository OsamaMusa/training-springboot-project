package com.example.trainingproject.Services;

import com.example.trainingproject.CustomExeptions.MyResourceNotFoundException;
import com.example.trainingproject.Entities.Package;
import com.example.trainingproject.IServices.IPackageService;
import com.example.trainingproject.IRepositories.IPackageRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PackageService implements IPackageService {

    @Autowired
    private IPackageRepository PackageRepository;
    @Autowired
    private LoggerService loggerService;
    Logger logger = loggerService.logger;

    @Override
    public Package insert(Package myPackage) {
        if(myPackage == null)
            throw new MyResourceNotFoundException("Can't insert null as Package object");
        Package res = PackageRepository.save(myPackage);
        logger.info("Inserted Package : "+ res.toString());
        return res;
    }

    @Override
    public Package findById(int id) {

        Optional<Package> res =  PackageRepository.findById(id);
        if(res.isPresent()){
            logger.info("Existed Package : "+ res.get().toString());
            return  res.get();
        }
        logger.info("Package Id : "+ id+" not found !");
        throw new MyResourceNotFoundException("there is no package to display");

    }

    @Override
    public List<Package> getAll() {
        List<Package> res = PackageRepository.findAll();
        logger.info("Receved "+res.size() +" Package : ");
        if(res.size() > 0)
          return res;
        throw new MyResourceNotFoundException("there is no package to display");

    }

    @Override
    public boolean delete(int id) {
        Optional<Package> myPackage =  PackageRepository.findById(id);
        if(myPackage.isPresent() ){
            logger.info("Deleted Package : "+ myPackage.get().toString());
            PackageRepository.delete(myPackage.get());
            return  true;
        }
        logger.info("Package Id : "+ id+" not found !");
        throw new MyResourceNotFoundException("there is no package to delete");

    }

    @Override
    public Package update(int id, Package myPackage) {
        if(myPackage== null)
            throw new MyResourceNotFoundException("Can't update null as Package object");
        Optional<Package> foundedPackage =  PackageRepository.findById(id);
        if(foundedPackage.isPresent()){
            logger.info("Updated Package : "+ myPackage.toString());
            return  PackageRepository.save(myPackage);
        }
        logger.info("Package Id : "+ id+" not found !");
        throw new MyResourceNotFoundException("there is no package to update");

    }
}

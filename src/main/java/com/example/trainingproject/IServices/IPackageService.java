package com.example.trainingproject.IServices;

import com.example.trainingproject.Entities.Package;

import java.util.List;

public interface IPackageService {
    Package insert(Package Package);

    Package findById(int id);

    List<Package> getAll();

    boolean delete(int id);

    Package update(int id, Package myPackage);
}

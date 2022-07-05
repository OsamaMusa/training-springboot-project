package com.example.trainingproject.IRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.trainingproject.Entities.Package;
import org.springframework.stereotype.Repository;

@Repository
public interface IPackageRepository extends JpaRepository<Package,Integer> {

}

package com.example.trainingproject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.trainingproject.Entities.Package;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPackageRepository extends JpaRepository<Package,Integer> {

}

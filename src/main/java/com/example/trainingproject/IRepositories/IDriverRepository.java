package com.example.trainingproject.IRepositories;

import com.example.trainingproject.Entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDriverRepository extends JpaRepository<Driver,Integer> {
    List<Driver> findDriverByFullName(String fullName);
}

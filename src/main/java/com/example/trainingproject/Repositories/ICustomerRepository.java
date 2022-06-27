package com.example.trainingproject.Repositories;

import com.example.trainingproject.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
   List<Customer> findCustomerByFullName(String fullName );
}

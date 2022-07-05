package com.example.trainingproject.IRepositories;

import com.example.trainingproject.Entities.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ICustomerRepository  extends IGeneralRepository<Customer> {//JpaRepository<Customer,Integer> {
   List<Customer> findCustomerByFullName(String fullName );
}

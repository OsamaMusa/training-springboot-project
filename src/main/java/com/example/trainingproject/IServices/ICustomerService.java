package com.example.trainingproject.IServices;

import com.example.trainingproject.Entities.Customer;

import java.util.List;

public interface ICustomerService {
    Customer insert(Customer customer);

    Customer findById(int id);

    List<Customer> findByName(String fullName);

    List<Customer> getAll();

    boolean delete(int id);

    Customer update(int id, Customer customer);
}

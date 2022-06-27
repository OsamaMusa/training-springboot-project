package com.example.trainingproject.Services;

import com.example.trainingproject.Entities.Customer;
import com.example.trainingproject.Repositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService  {

    @Autowired
    private ICustomerRepository customerRepository;

    public Customer addCustomer(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    public Customer findCustomerById(int id) {

        Customer customer =  customerRepository.findById(id).orElse(null);
        if(customer != null){
            return  customer;
        }
        return null;

    }

    public List<Customer> findCustomersByName(String fullName) {
        List<Customer> customers =  customerRepository.findCustomerByFullName(fullName);
        if(customers != null ){
            return  customers;
        }
        return null;

    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public boolean deleteCustomer(int id) {
        Customer foundedCustomer =  customerRepository.findById(id).orElse(null);
        if(foundedCustomer != null ){
            customerRepository.delete(foundedCustomer);
            return  true;
        }
        return false;

    }

    public Customer updateCustomer(int id , Customer customer) {
        Customer foundedCustomer =  customerRepository.findById(id).orElse(null);
        if(foundedCustomer != null && customer != null){
            return  customerRepository.save(customer);
        }
        return null;

    }
}

package com.example.trainingproject.Services;

import com.example.trainingproject.Entities.Customer;
import com.example.trainingproject.Repositories.ICustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService  {

    @Autowired
    private ICustomerRepository customerRepository;
    Logger logger = LoggerFactory.getLogger(CustomerService.class);

    public Customer addCustomer(Customer customer) {
        Customer res = customerRepository.save(customer);
        logger.info("Inserted customer : "+ res.toString());
        return res;
    }

    public Customer findCustomerById(int id) {

        Customer res =  customerRepository.findById(id).orElse(null);
        if(res != null){
            logger.info("Existed customer : "+ res.toString());
            return  res;
        }
        logger.info("Customer Id : "+ id+" not found !");
        return null;

    }

    public List<Customer> findCustomersByName(String fullName) {
        List<Customer> customers =  customerRepository.findCustomerByFullName(fullName);
        if(customers != null ){
            logger.info("Existed customer : "+ customers.toString());
            return  customers;
        }
        logger.info("Customer Name : "+ fullName +" not found !");
        return null;

    }

    public List<Customer> getAllCustomers() {
        List<Customer> res = customerRepository.findAll();
        logger.info("Receved "+res.size() +" customer : ");
        return res;
    }

    public boolean deleteCustomer(int id) {
        Customer customer =  customerRepository.findById(id).orElse(null);
        if(customer != null ){
            logger.info("Deleted customer : "+ customer.toString());
            customerRepository.delete(customer);
            return  true;
        }
        logger.info("Customer Id : "+ id+" not found !");
        return false;

    }

    public Customer updateCustomer(int id , Customer customer) {
        Customer foundedCustomer =  customerRepository.findById(id).orElse(null);
        if(foundedCustomer != null && customer != null){
            logger.info("Updated customer : "+ customer.toString());
            return  customerRepository.save(customer);
        }
        logger.info("Customer Id : "+ id+" not found !");
        return null;

    }
}

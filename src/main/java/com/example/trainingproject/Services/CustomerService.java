package com.example.trainingproject.Services;

import com.example.trainingproject.Entities.Customer;
import com.example.trainingproject.IServices.ICustomerService;
import com.example.trainingproject.Repositories.ICustomerRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private LoggerService loggerService;
    Logger logger = loggerService.logger;

    @Override
    public Customer insert(Customer customer) {
        Customer res = customerRepository.save(customer);
        logger.info("Inserted customer : "+ res.toString());
        return res;
    }

    @Override
    public Customer findById(int id) {

        Optional<Customer> res =  customerRepository.findById(id);
        if(res.isPresent()){
            logger.info("Existed customer : "+ res.get().toString());
            return  res.get();
        }
        logger.info("Customer Id : "+ id+" not found !");
        return null;

    }

    @Override
    public List<Customer> findByName(String fullName) {
        List<Customer> customers =  customerRepository.findCustomerByFullName(fullName);
        if(customers != null ){
            logger.info("Existed customer : "+ customers.toString());
            return  customers;
        }
        logger.info("Customer Name : "+ fullName +" not found !");
        return null;

    }

    @Override
    public List<Customer> getAll() {
        List<Customer> res = customerRepository.findAll();
        logger.info("Receved "+res.size() +" customer : ");
        return res;
    }

    @Override
    public boolean delete(int id) {
        Optional<Customer> customer =  customerRepository.findById(id);
        if(customer.isPresent() ){
            logger.info("Deleted customer : "+ customer.get().toString());
            customerRepository.delete(customer.get());
            return  true;
        }
        logger.info("Customer Id : "+ id+" not found !");
        return false;

    }

    @Override
    public Customer update(int id, Customer customer) {
        Optional<Customer> foundedCustomer =  customerRepository.findById(id);
        if(foundedCustomer.isPresent()  && customer != null){
            logger.info("Updated customer : "+ customer.toString());
            return  customerRepository.save(customer);
        }
        logger.info("Customer Id : "+ id+" not found !");
        return null;

    }
}

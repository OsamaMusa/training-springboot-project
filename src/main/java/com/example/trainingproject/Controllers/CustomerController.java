package com.example.trainingproject.Controllers;

import com.example.trainingproject.Entities.Customer;
import com.example.trainingproject.Services.CarService;
import com.example.trainingproject.Services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    private CustomerService customerService ;

    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();

    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }
    @PutMapping("{id}")
    public Customer updateCustomer(@PathVariable("id") int id,@RequestBody Customer customer){
        return customerService.updateCustomer(id,customer);
    }

    @GetMapping("{id}")
    @Transactional()
    @Cacheable("customer-cache")
    public Customer findCustomerById(@PathVariable("id") int id){
        return customerService.findCustomerById(id);

    }

    @DeleteMapping("{id}")
    @CacheEvict("customer-cache")
    public boolean deleteCustomerById(@PathVariable("id") int id){
        return customerService.deleteCustomer(id);
    }
    @GetMapping("name/{name}")
    @Cacheable("customer-cache")
    public List<Customer> findCustomersByName(@PathVariable("name") String name){
        return customerService.findCustomersByName(name);
    }
}

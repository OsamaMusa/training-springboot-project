package com.example.trainingproject.Controllers;

import com.example.trainingproject.Entities.Customer;
import com.example.trainingproject.Services.CarService;
import com.example.trainingproject.Services.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
@Tag(name = "Customers" , description = "CRUD operation for customer entity")
public class CustomerController {


    @Autowired
    private CustomerService customerService ;

    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();

    }

    @PostMapping
    public Customer addCustomer(@Valid @RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }
    @PutMapping("{id}")
    public Customer updateCustomer(@PathVariable("id") int id,@Valid @RequestBody Customer customer){
        return customerService.updateCustomer(id,customer);
    }

    @GetMapping("{id}")
    @Transactional()
    @Cacheable("${cache-name}")
    public Customer findCustomerById(@PathVariable("id") int id){
        return customerService.findCustomerById(id);

    }

    @DeleteMapping("{id}")
    @CacheEvict("${cache-name}")
    public boolean deleteCustomerById(@PathVariable("id") int id){
        return customerService.deleteCustomer(id);
    }
    @GetMapping("name/{name}")
    @Cacheable("${cache-name}")
    public List<Customer> findCustomersByName(@PathVariable("name") String name){
        return customerService.findCustomersByName(name);
    }
}

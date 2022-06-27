package com.example.trainingproject.Controllers;

import com.example.trainingproject.Entities.Customer;
import com.example.trainingproject.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Customer findCustomerById(@PathVariable("id") int id){
        return customerService.findCustomerById(id);
    }
    @DeleteMapping("{id}")
    public boolean deleteCustomerById(@PathVariable("id") int id){
        return customerService.deleteCustomer(id);
    }
    @GetMapping("name/{name}")
    public List<Customer> findCustomersByName(@PathVariable("name") String name){
        return customerService.findCustomersByName(name);
    }
}

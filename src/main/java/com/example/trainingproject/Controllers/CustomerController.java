package com.example.trainingproject.Controllers;

import com.example.trainingproject.Entities.Customer;
import com.example.trainingproject.Services.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
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
    public List<Customer> getAll(){
        return customerService.getAll();

    }

    @PostMapping
    public Customer insert(@Valid @RequestBody Customer customer){
        return customerService.insert(customer);
    }
    @PutMapping("{id}")
    public Customer update(@PathVariable("id") int id,@Valid @RequestBody Customer customer){
        return customerService.update(id,customer);
    }

    @GetMapping("{id}")
    @Transactional()
    @Cacheable("${cache-name}")
    public Customer findById(@PathVariable("id") int id){
        return customerService.findById(id);

    }

    @DeleteMapping("{id}")
    @CacheEvict("${cache-name}")
    public boolean deleteById(@PathVariable("id") int id){
        return customerService.delete(id);
    }
    @GetMapping("name/{name}")
    @Cacheable("${cache-name}")
    public List<Customer> findByName(@PathVariable("name") String name){
        return customerService.findByName(name);
    }
}

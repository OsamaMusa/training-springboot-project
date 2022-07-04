package com.example.trainingproject.Controllers;

import com.example.trainingproject.Entities.Order;
import com.example.trainingproject.Services.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/order")
@Tag(name = "Orders" , description = "CRUD operation for order entity")
public class OrderController {


    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAll(){
        return orderService.getAll();

    }

    @PostMapping
    public Order insert(@Valid @RequestBody Order order){
        return orderService.insert(order);
    }
    @PutMapping("{id}")
    public Order update(@PathVariable("id") int id,@Valid @RequestBody Order order){
        return orderService.update(id,order);
    }

    @GetMapping("{id}")
    @Transactional()
    @Cacheable("${cache-name}")
    public Order findById(@PathVariable("id") int id){
        return orderService.findById(id);

    }

    @DeleteMapping("{id}")
    @CacheEvict("${cache-name}")
    public boolean deleteById(@PathVariable("id") int id){
        return orderService.delete(id);
    }

}

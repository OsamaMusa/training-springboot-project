package com.example.trainingproject.Controllers;

import com.example.trainingproject.Entities.Customer;
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
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();

    }

    @PostMapping
    public Order addCustomer(@Valid @RequestBody Order order){
        return orderService.addOrder(order);
    }
    @PutMapping("{id}")
    public Order updateOrder(@PathVariable("id") int id,@Valid @RequestBody Order order){
        return orderService.updateOrder(id,order);
    }

    @GetMapping("{id}")
    @Transactional()
    @Cacheable("${cache-name}")
    public Order findOrderById(@PathVariable("id") int id){
        return orderService.findOrderById(id);

    }

    @DeleteMapping("{id}")
    @CacheEvict("${cache-name}")
    public boolean deleteOrderById(@PathVariable("id") int id){
        return orderService.deleteOrder(id);
    }

}

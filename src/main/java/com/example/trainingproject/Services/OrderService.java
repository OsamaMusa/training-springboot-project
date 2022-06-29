package com.example.trainingproject.Services;

import com.example.trainingproject.Entities.Customer;
import com.example.trainingproject.Entities.Order;
import com.example.trainingproject.Repositories.ICustomerRepository;
import com.example.trainingproject.Repositories.IOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService  {

    @Autowired
    private IOrderRepository orderRepository;
    Logger logger = LoggerFactory.getLogger(OrderService.class);

    public Order addOrder(Order order) {
        Order res = orderRepository.save(order);
        logger.info("Inserted order : "+ res.toString());
        return res;
    }

    public Order findOrderById(int id) {

        Order res =  orderRepository.findById(id).orElse(null);
        if(res != null){
            logger.info("Existed Order : "+ res.toString());
            return  res;
        }
        logger.info("Order Id : "+ id+" not found !");
        return null;

    }


    public List<Order> getAllOrders() {
        List<Order> res = orderRepository.findAll();
        logger.info("Receved "+res.size() +" order . ");
        return res;
    }

    public boolean deleteOrder(int id) {
        Order order =  orderRepository.findById(id).orElse(null);
        if(order != null ){
            logger.info("Deleted order : "+ order.toString());
            orderRepository.delete(order);
            return  true;
        }
        logger.info("Customer Id : "+ id+" not found !");
        return false;

    }

    public Order updateOrder(int id , Order order) {
        Order res =  orderRepository.findById(id).orElse(null);
        if(res != null && order != null){
            logger.info("Updated customer : "+ order.toString());
            return  orderRepository.save(order);
        }
        logger.info("Customer Id : "+ id+" not found !");
        return null;

    }
}

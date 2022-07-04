package com.example.trainingproject.Services;

import com.example.trainingproject.Entities.Order;
import com.example.trainingproject.IServices.IOrderService;
import com.example.trainingproject.Repositories.IOrderRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;
    @Autowired
    private LoggerService loggerService;
    Logger logger = loggerService.logger;

    @Override
    public Order insert(Order order) {
        Order res = orderRepository.save(order);
        logger.info("Inserted order : "+ res.toString());
        return res;
    }

    @Override
    public Order findById(int id) {

        Optional<Order> res =  orderRepository.findById(id);
        if(res.isPresent()){
            logger.info("Existed Order : "+ res.get().toString());
            return  res.get();
        }
        logger.info("Order Id : "+ id+" not found !");
        return null;

    }


    @Override
    public List<Order> getAll() {
        List<Order> res = orderRepository.findAll();
        logger.info("Receved "+res.size() +" order . ");
        return res;
    }

    @Override
    public boolean delete(int id) {
        Optional<Order> order =  orderRepository.findById(id);
        if(order.isPresent() ){
            logger.info("Deleted order : "+ order.get().toString());
            orderRepository.delete(order.get());
            return  true;
        }
        logger.info("Customer Id : "+ id+" not found !");
        return false;

    }

    @Override
    public Order update(int id, Order order) {
        Optional<Order> res =  orderRepository.findById(id);
        if(res.isPresent() && order != null){
            logger.info("Updated customer : "+ order.toString());
            return  orderRepository.save(order);
        }
        logger.info("Customer Id : "+ id+" not found !");
        return null;

    }
}

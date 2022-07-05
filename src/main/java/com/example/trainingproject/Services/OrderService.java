package com.example.trainingproject.Services;

import com.example.trainingproject.CustomExeptions.MyResourceNotFoundException;
import com.example.trainingproject.Entities.Order;
import com.example.trainingproject.IServices.IOrderService;
import com.example.trainingproject.IRepositories.IOrderRepository;
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
        if(order == null)
            throw new MyResourceNotFoundException("Can't insert null as Order object");
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
        throw new MyResourceNotFoundException("there is no order to display");

    }


    @Override
    public List<Order> getAll() {
        List<Order> res = orderRepository.findAll();
        logger.info("Receved "+res.size() +" order . ");
        if(res.size() > 0)
           return res;
        throw new MyResourceNotFoundException("there is no order to display");

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
        throw new MyResourceNotFoundException("there is no order to delete");

    }

    @Override
    public Order update(int id, Order order) {
        if(order == null)
            throw new MyResourceNotFoundException("Can't update null as Order object");

        Optional<Order> res =  orderRepository.findById(id);
        if(res.isPresent() ){
            logger.info("Updated customer : "+ order.toString());
            return  orderRepository.save(order);
        }
        logger.info("Customer Id : "+ id+" not found !");
        throw new MyResourceNotFoundException("there is no order to update");

    }
}

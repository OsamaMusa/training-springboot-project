package com.example.trainingproject.Services;

import com.example.trainingproject.CustomExeptions.MyResourceNotFoundException;
import com.example.trainingproject.Entities.Product;
import com.example.trainingproject.IServices.IProductService;
import com.example.trainingproject.IRepositories.IProductRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository ProductRepository;
    @Autowired
    private LoggerService loggerService;
    Logger logger = loggerService.logger;

    @Override
    public Product insert(Product product) {
        if(product == null)
            throw new MyResourceNotFoundException("Can't insert null as Product object");
        Product res = ProductRepository.save(product);
        logger.info("Inserted Product : "+ res.toString());
        return res;
    }

    @Override
    public Product findById(int id) {

       Optional<Product>  res =  ProductRepository.findById(id);
        if(res.isPresent()){
            logger.info("Existed Product : "+ res.get().toString());
            return  res.get();
        }
        logger.info("Product Id : "+ id+" not found !");
        throw new MyResourceNotFoundException("there is no product to display");

    }

    @Override
    public List<Product> getAll() {
        List<Product> res = ProductRepository.findAll();
        logger.info("Receved "+res.size() +" Product : ");
        if(res.size() > 0)
          return res;
        throw new MyResourceNotFoundException("there is no product to display");

    }

    @Override
    public boolean delete(int id) {
        Optional<Product> product =  ProductRepository.findById(id);
        if(product.isPresent() ){
            logger.info("Deleted Product : "+ product.get().toString());
            ProductRepository.delete(product.get());
            return  true;
        }
        logger.info("Product Id : "+ id+" not found !");
        throw new MyResourceNotFoundException("there is no product to delete");

    }

    @Override
    public Product update(int id, Product product) {
        if(product == null)
            throw new MyResourceNotFoundException("Can't update null as Product object");
        Optional<Product> foundedProduct =  ProductRepository.findById(id);
        if(foundedProduct.isPresent()){
            logger.info("Updated Product : "+ product.toString());
            return  ProductRepository.save(product);
        }
        logger.info("Product Id : "+ id+" not found !");
        throw new MyResourceNotFoundException("there is no product to update");

    }
}

package com.example.trainingproject.Services;

import com.example.trainingproject.Entities.Product;
import com.example.trainingproject.Repositories.IProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService  {

    @Autowired
    private IProductRepository ProductRepository;
    Logger logger = LoggerFactory.getLogger(ProductService.class);

    public Product addProduct(Product Product) {
        Product res = ProductRepository.save(Product);
        logger.info("Inserted Product : "+ res.toString());
        return res;
    }

    public Product findProductById(int id) {

        Product res =  ProductRepository.findById(id).orElse(null);
        if(res != null){
            logger.info("Existed Product : "+ res.toString());
            return  res;
        }
        logger.info("Product Id : "+ id+" not found !");
        return null;

    }

    public List<Product> getAllProducts() {
        List<Product> res = ProductRepository.findAll();
        logger.info("Receved "+res.size() +" Product : ");
        return res;
    }

    public boolean deleteProduct(int id) {
        Product Product =  ProductRepository.findById(id).orElse(null);
        if(Product != null ){
            logger.info("Deleted Product : "+ Product.toString());
            ProductRepository.delete(Product);
            return  true;
        }
        logger.info("Product Id : "+ id+" not found !");
        return false;

    }

    public Product updateProduct(int id , Product Product) {
        Product foundedProduct =  ProductRepository.findById(id).orElse(null);
        if(foundedProduct != null && Product != null){
            logger.info("Updated Product : "+ Product.toString());
            return  ProductRepository.save(Product);
        }
        logger.info("Product Id : "+ id+" not found !");
        return null;

    }
}

package com.example.trainingproject.Services;

import com.example.trainingproject.Entities.Product;
import com.example.trainingproject.Repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private IProductRepository ProductRepository;

    public Product addProduct(Product Product) {
        ProductRepository.save(Product);
        return Product;
    }

    public Product findProductById(int id) {

        Product Product =  ProductRepository.findById(id).orElse(null);
        if(Product != null){
            return  Product;
        }
        return null;

    }

    public List<Product> getAllProducts() {
        return ProductRepository.findAll();
    }

    public boolean deleteProduct(int id) {
        Product existedProduct =  ProductRepository.findById(id).orElse(null);
        if(existedProduct != null ){
            ProductRepository.delete(existedProduct);
            return  true;
        }
        return false;

    }

    public Product updateProduct(int id , Product Product) {
        Product existedProduct =  ProductRepository.findById(id).orElse(null);
        if(existedProduct != null && Product != null){
            return  ProductRepository.save(Product);
        }
        return null;

    }
}

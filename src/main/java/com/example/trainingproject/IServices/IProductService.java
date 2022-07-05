package com.example.trainingproject.IServices;

import com.example.trainingproject.Entities.Product;

import java.util.List;

public interface IProductService {
    Product insert(Product product);

    Product findById(int id);

    List<Product> getAll();

    boolean delete(int id);

    Product update(int id, Product product);
}

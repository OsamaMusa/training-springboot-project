package com.example.trainingproject.Controllers;

import com.example.trainingproject.Entities.Product;
import com.example.trainingproject.Services.CarService;
import com.example.trainingproject.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService ProductService ;

    @GetMapping
    public List<Product> getAllProducts(){
        return ProductService.getAllProducts();
    }
    @PostMapping
    public Product addProduct(@RequestBody Product Product){
        return ProductService.addProduct(Product);
    }
    @PutMapping("{id}")
    public Product updateProduct(@PathVariable("id") int id,@RequestBody Product Product){
        return ProductService.updateProduct(id,Product);
    }

    @GetMapping("{id}")
    public Product findProductById(@PathVariable("id") int id){
        return ProductService.findProductById(id);
    }
    @DeleteMapping("{id}")
    public boolean deleteProductById(@PathVariable("id") int id){
        return ProductService.deleteProduct(id);
    }

}

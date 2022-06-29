package com.example.trainingproject.Controllers;

import com.example.trainingproject.Entities.Product;
import com.example.trainingproject.Services.CarService;
import com.example.trainingproject.Services.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
@Tag(name = "Products" , description = "CRUD operation for product entity")
public class ProductController {

    @Autowired
    private ProductService ProductService ;
    @GetMapping
    public List<Product> getAllProducts(){
        return ProductService.getAllProducts();
    }
    @PostMapping
    public Product addProduct(@Valid  @RequestBody Product Product){
        return ProductService.addProduct(Product);
    }
    @PutMapping("{id}")
    public Product updateProduct(@PathVariable("id") int id,@Valid @RequestBody Product Product){
        return ProductService.updateProduct(id,Product);
    }

    @GetMapping("{id}")
    @Cacheable("${cache-name}")
    public Product findProductById(@PathVariable("id") int id){
        return ProductService.findProductById(id);
    }
    @DeleteMapping("{id}")
    @CacheEvict("${cache-name}")
    public boolean deleteProductById(@PathVariable("id") int id){
        return ProductService.deleteProduct(id);
    }

}

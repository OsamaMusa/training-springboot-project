package com.example.trainingproject.Controllers;

import com.example.trainingproject.Entities.Product;
import com.example.trainingproject.Services.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Product> getAll(){
        return ProductService.getAll();
    }
    @PostMapping
    public Product insert(@Valid  @RequestBody Product product){
        return ProductService.insert(product);
    }
    @PutMapping("{id}")
    public Product update(@PathVariable("id") int id,@Valid @RequestBody Product product){
        return ProductService.update(id,product);
    }

    @GetMapping("{id}")
    @Cacheable("${cache-name}")
    public Product findById(@PathVariable("id") int id){
        return ProductService.findById(id);
    }
    @DeleteMapping("{id}")
    @CacheEvict("${cache-name}")
    public boolean deleteById(@PathVariable("id") int id){
        return ProductService.delete(id);
    }

}

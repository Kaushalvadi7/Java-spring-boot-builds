package com.springboot.spring_security_jwt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/products")
public class ProductController {

    private record Product(Integer productId, String productName, Double price) {
    }

    List<Product> products = new ArrayList<>(List.of(
            new Product(1, "iphone", 1000000.0),
            new Product(2, "Mac Pro", 200000.0),
            new Product(3, "ipad", 120000.0)
    ));

    @GetMapping
    public List<Product> getProducts() {
        return products;
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        products.add(product);
        return product;
    }
}

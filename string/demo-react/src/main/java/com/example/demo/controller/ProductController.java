package com.example.demo.controller;

import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public List<ProductEntity> getProductList() {
        return productRepository.findAll();

    }

    @PostMapping("/add")
    public ResponseEntity<ProductEntity> addProduct(@RequestBody ProductEntity product) {
        ProductEntity savedProduct = productRepository.save(product);
        return ResponseEntity.ok(savedProduct);
    }
}


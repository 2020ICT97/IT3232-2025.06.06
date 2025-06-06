package me.neranjana.spring.ica2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.neranjana.spring.ica2.models.Product;
import me.neranjana.spring.ica2.services.ProductService;


@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<List<Product>>(service.getProducts(), HttpStatus.OK);
    }
    
    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> filterProductsByCategoryId(@PathVariable("id") int id) {
        return new ResponseEntity<List<Product>>(service.filterProductsByCategoryId(id), HttpStatus.OK);
    }
}

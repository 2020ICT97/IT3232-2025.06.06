package me.neranjana.spring.ica2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import me.neranjana.spring.ica2.models.Product;
import me.neranjana.spring.ica2.repo.ProductRepo;

@Service
public class ProductService {
    @Autowired
    private ProductRepo repo;


    public List<Product> getProducts() {
        return repo.findAll();
    }

    public List<Product> filterProductsByCategoryId(int id) {
        if (repo.filterByCategoryId(id).isEmpty()) {
            throw new EntityNotFoundException("No Products Found");
        }

        return repo.filterByCategoryId(id);
    }
}

package me.neranjana.spring.ica2.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import me.neranjana.spring.ica2.models.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product AS p WHERE p.category.id = ?1")
    public List<Product> filterByCategoryId(int id);
}

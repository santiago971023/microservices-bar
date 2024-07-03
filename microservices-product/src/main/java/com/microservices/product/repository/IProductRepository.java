package com.microservices.product.repository;

import com.microservices.product.entities.Category;
import com.microservices.product.entities.Product;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String name);




    @Query(value = "SELECT * FROM products WHERE category = :category", nativeQuery = true)
    List<Product> findByCategory(@Param("category") String category);

}

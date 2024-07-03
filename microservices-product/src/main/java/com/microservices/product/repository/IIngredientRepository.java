package com.microservices.product.repository;

import com.microservices.product.dtos.IngredientResponseDTO;
import com.microservices.product.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IIngredientRepository extends JpaRepository<Ingredient, Long> {
    IngredientResponseDTO findByName(String name);
}

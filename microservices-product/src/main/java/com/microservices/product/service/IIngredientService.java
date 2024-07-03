package com.microservices.product.service;

import com.microservices.product.dtos.IngredientRequestDTO;
import com.microservices.product.dtos.IngredientResponseDTO;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface IIngredientService {

    void save(IngredientRequestDTO ingredientRequestDTO);

    IngredientResponseDTO findByName(String name);

    List<IngredientResponseDTO> findAll();

    void update(IngredientRequestDTO ingredientRequestDTO);

    void delete(Long id);

}

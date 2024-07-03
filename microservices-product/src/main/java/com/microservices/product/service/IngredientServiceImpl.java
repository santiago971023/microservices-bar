package com.microservices.product.service;

import com.microservices.product.dtos.IngredientRequestDTO;
import com.microservices.product.dtos.IngredientResponseDTO;
import com.microservices.product.dtos.ProductForListResponseDTO;
import com.microservices.product.entities.Ingredient;
import com.microservices.product.entities.Product;
import com.microservices.product.repository.IIngredientRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IIngredientService{

    private final IIngredientRepository ingredientRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public void save(IngredientRequestDTO ingredientRequestDTO) {
        Ingredient ingredient = modelMapper.map(ingredientRequestDTO, Ingredient.class);
        ingredientRepository.save(ingredient);
    }

    @Override
    public IngredientResponseDTO findByName(String name) {
        return ingredientRepository.findByName(name);
    }

    @Override
    public List<IngredientResponseDTO> findAll() {
        List<Ingredient> ingredients = ingredientRepository.findAll();
        return ingredients.stream()
                .map(ingredient -> modelMapper.map(ingredient, IngredientResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void update(IngredientRequestDTO ingredientRequestDTO) {
        IngredientResponseDTO ingredientResponseDTO = ingredientRepository.findByName(ingredientRequestDTO.getName());
        if (ingredientResponseDTO != null){
            Ingredient ingredient = modelMapper.map(ingredientRequestDTO, Ingredient.class);
            ingredientRepository.save(ingredient);
        }else{
            throw new RuntimeException("Ingredient not found by name");
        }

    }

    @Override
    public void delete(Long id) {
        if(ingredientRepository.existsById(id)){
            ingredientRepository.deleteById(id);
        }else{
            throw new RuntimeException("Ingredient with id: "+ id + " not found.");
        }
    }
}

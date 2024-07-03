package com.microservices.product.controller;


import com.microservices.product.dtos.IngredientRequestDTO;
import com.microservices.product.dtos.IngredientResponseDTO;
import com.microservices.product.service.IIngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ingredient")
public class IngredientController {

    private final IIngredientService ingredientService;

    public IngredientController(IIngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @Transactional
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody IngredientRequestDTO ingredientRequestDTO){
        ingredientService.save(ingredientRequestDTO);
    }

    @GetMapping("/find-by-name/{name}")
    public ResponseEntity<IngredientResponseDTO> findByName(@PathVariable String name){
        return ResponseEntity.ok(ingredientService.findByName(name));
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(ingredientService.findAll());
    }

    @PutMapping("/update")
    public void update( @RequestBody IngredientRequestDTO ingredientRequestDTO){
        ingredientService.update(ingredientRequestDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        ingredientService.delete(id);
    }



}

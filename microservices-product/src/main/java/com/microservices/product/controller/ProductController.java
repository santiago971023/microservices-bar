package com.microservices.product.controller;

import com.microservices.product.dtos.ProductRequestDTO;
import com.microservices.product.dtos.ProductResponseDTO;
import com.microservices.product.service.IProductService;
import jakarta.ws.rs.Path;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@Transactional
@RequestMapping("/api/product")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody ProductRequestDTO productRequestDTO){
        productService.saveProduct(productRequestDTO);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody ProductRequestDTO productRequestDTO){
        productService.updateProduct(productRequestDTO);
    }

    @GetMapping("/find-by-name/{name}")
    public ResponseEntity<ProductResponseDTO> findByName(@PathVariable String name){
        return ResponseEntity.ok(productService.findByName(name));
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/find-by-category/{category}")
    public ResponseEntity<?> findByCategory(@PathVariable String category){
        return  ResponseEntity.ok(productService.findByCategory(category));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        productService.delete(id);
    }



}

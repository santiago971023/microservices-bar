package com.microservices.product.service;


import com.microservices.product.dtos.ProductForListResponseDTO;
import com.microservices.product.dtos.ProductRequestDTO;
import com.microservices.product.dtos.ProductResponseDTO;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface IProductService {

    void saveProduct(ProductRequestDTO productRequestDTO);

    ProductResponseDTO findByName(String name);

    List<ProductForListResponseDTO> findAll();

    void updateProduct(ProductRequestDTO productRequestDTO);

    void delete(Long id);

    List<ProductForListResponseDTO> findByCategory(String category);




}

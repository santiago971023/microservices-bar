package com.microservices.product.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {

    private Long id;

    private String name;

    private String description;

    private List<IngredientRequestDTO> ingredientRequestDTOList;

    private Long photoId;

    private Double price;

    private Boolean isPrepared;
}

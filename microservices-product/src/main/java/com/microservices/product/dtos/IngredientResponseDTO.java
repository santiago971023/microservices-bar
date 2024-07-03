package com.microservices.product.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IngredientResponseDTO {

    private Long id;

    private String name;

    private String extend;

    private Double amound;

}

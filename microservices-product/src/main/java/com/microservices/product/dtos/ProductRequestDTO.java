package com.microservices.product.dtos;

import com.microservices.product.entities.Ingredient;
import lombok.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {

    private String name;

    private String description;

    private List<IngredientRequestDTO> ingredientRequestDTOList;

    private Long photoId;

    private Double price;

    private Boolean isPrepared;

}

package com.microservices.product.dtos;


import com.microservices.product.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductForListResponseDTO {

    private String name;

    private String description;

    private Long photoId;

    private Double price;

    private Category category;

}

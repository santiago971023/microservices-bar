package com.microservices.product.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Ingredient> ingredients;
    @Column(name = "photo_id")
    private Long photoId;
    @Column(name = "is_prepared")
    private Boolean isPrepared;
    @Enumerated(EnumType.STRING)
    private Category category;

}

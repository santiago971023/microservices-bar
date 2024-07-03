package com.microservices.product.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ingredients")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private Double amount;
    private String extend;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}

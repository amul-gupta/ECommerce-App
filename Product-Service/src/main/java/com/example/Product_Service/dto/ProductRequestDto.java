package com.example.Product_Service.dto;


import jakarta.persistence.Entity;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequestDto {

    private String name;

    private String description;

    private Double price;

    private Integer stockQuantity;

    private String categoryId;

}

package com.example.Product_Service.dto;

import java.time.LocalDateTime;

import com.example.Product_Service.entity.Category;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponseDto {

    private String productId;

    private String name;

    private String description;

    private Double price;

    private Integer stockQuantity;

    private Boolean isStock;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Category category;
}

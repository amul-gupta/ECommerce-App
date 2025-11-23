package com.example.Order_Service.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponseDto {

    private String productId;

    private String name;

    private Double price;

    private Integer stockQuantity;

}

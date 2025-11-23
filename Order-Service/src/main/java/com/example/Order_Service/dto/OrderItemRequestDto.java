package com.example.Order_Service.dto;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemRequestDto {

    private String productId;

    private Integer quantity;

}

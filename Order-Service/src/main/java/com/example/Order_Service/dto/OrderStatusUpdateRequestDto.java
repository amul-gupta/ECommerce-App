package com.example.Order_Service.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderStatusUpdateRequestDto {

    private String orderId;

    private String status;
}
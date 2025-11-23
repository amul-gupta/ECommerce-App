package com.example.Order_Service.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequestDto {

    private String customerId;

    private List<OrderItemRequestDto> items = new ArrayList<>();
}

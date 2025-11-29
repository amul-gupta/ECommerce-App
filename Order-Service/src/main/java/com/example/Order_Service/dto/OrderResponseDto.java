package com.example.Order_Service.dto;


import com.example.Order_Service.entity.OrderItem;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponseDto {

    private String orderId;

    private String customerId;

    private LocalDateTime orderedDate;

    private String status;

    private Double totalAmount;

    private List<OrderItem> items = new ArrayList<>();

}

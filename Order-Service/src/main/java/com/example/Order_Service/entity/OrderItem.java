package com.example.Order_Service.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "orderItem")
public class OrderItem {

    @Id
    private String orderItemId;

    private String orderId;

    private String productId;

    private Integer quantity;

    private Double price;

}

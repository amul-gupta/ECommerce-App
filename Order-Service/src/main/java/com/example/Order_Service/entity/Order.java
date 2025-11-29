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
@Entity(name = "orders")
public class Order {

    @Id
    private String orderId;

    private String customerId;

    private LocalDateTime orderedDate = LocalDateTime.now();

    private Double totalAmount;

    private String status;

}

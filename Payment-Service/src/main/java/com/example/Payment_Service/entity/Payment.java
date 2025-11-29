package com.example.Payment_Service.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Payment {

    @Id
    private String paymentId;

    private String orderId;

    private String customerId;

    private Double amount;

    private LocalDateTime paymentDate = LocalDateTime.now();

    private String paymentStatus;

    private String transactionId;

}

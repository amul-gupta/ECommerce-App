package com.example.Payment_Service.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequestDto {

    private String orderId;

    private String customerId;

    private String amount;
}

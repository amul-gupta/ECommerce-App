package com.example.Payment_Service.dto;
import java.time.LocalDateTime;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentResponseDto {

    private String paymentId;

    private String orderId;

    private String customerId;

    private String amount;

    private LocalDateTime paymentDate;

    private String paymentStatus;

    private String transactionId;


}


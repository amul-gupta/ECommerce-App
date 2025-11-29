package com.example.Payment_Service.service;

import com.example.Payment_Service.dto.PaymentRequestDto;
import com.example.Payment_Service.dto.PaymentResponseDto;

public interface PaymentService {

    public PaymentResponseDto processPayment(PaymentRequestDto paymentRequestDto);

    public PaymentResponseDto getStatusOfOrderId(String orderId);
}

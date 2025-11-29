package com.example.Payment_Service.service.Impl;


import com.example.Payment_Service.client.OrderClient;
import com.example.Payment_Service.dto.PaymentRequestDto;
import com.example.Payment_Service.dto.PaymentResponseDto;
import com.example.Payment_Service.entity.Payment;
import com.example.Payment_Service.repository.PaymentRepository;
import com.example.Payment_Service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderClient orderClient;


    public PaymentResponseDto processPayment(PaymentRequestDto paymentRequestDto)
    {
        Payment payment = new Payment();
        payment.setPaymentId(UUID.randomUUID().toString());
        payment.setOrderId(paymentRequestDto.getOrderId());
        payment.setCustomerId(paymentRequestDto.getCustomerId());
        payment.setAmount(paymentRequestDto.getAmount());
        payment.setPaymentDate(LocalDateTime.now());

        boolean paymentSuccess = new Random().nextBoolean();
        if(paymentSuccess)
        {
            payment.setPaymentStatus("SUCCESS");
            payment.setTransactionId(UUID.randomUUID().toString());
            orderClient.updateOrderStatus(paymentRequestDto.getOrderId(), "CONFIRMED");
        }
        else
        {
            payment.setPaymentStatus("FAILED");
            payment.setTransactionId("Not Available");
            orderClient.updateOrderStatus(paymentRequestDto.getOrderId(), "CANCELLED");
        }

        paymentRepository.save(payment);

        return PaymentResponseDto.builder()
                .paymentId(payment.getPaymentId())
                .orderId(payment.getOrderId())
                .customerId(payment.getCustomerId())
                .amount(payment.getAmount())
                .paymentDate(payment.getPaymentDate())
                .paymentStatus(payment.getPaymentStatus())
                .transactionId(payment.getTransactionId())
                .build();
    }

    @Override
    public PaymentResponseDto getStatusOfOrderId(String orderId) {

        Payment payment = paymentRepository.findByOrderId(orderId);
        return PaymentResponseDto.builder()
                .paymentId(payment.getPaymentId())
                .orderId(payment.getOrderId())
                .customerId(payment.getCustomerId())
                .amount(payment.getAmount())
                .paymentDate(payment.getPaymentDate())
                .paymentStatus(payment.getPaymentStatus())
                .transactionId(payment.getTransactionId())
                .build();
    }
}

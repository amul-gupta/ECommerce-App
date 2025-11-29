package com.example.Payment_Service.controller;


import com.example.Payment_Service.dto.PaymentRequestDto;
import com.example.Payment_Service.dto.PaymentResponseDto;
import com.example.Payment_Service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    //process the payment
    @PostMapping("/create")
    public ResponseEntity<PaymentResponseDto> processPayment(@RequestBody PaymentRequestDto paymentRequestDto)
    {
       PaymentResponseDto saved = paymentService.processPayment(paymentRequestDto);
       return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    //to know the status of order id
    @GetMapping("/status/Id/{orderId}")
    public ResponseEntity<PaymentResponseDto> getStatusOfOrderId(@PathVariable String orderId)
    {
        PaymentResponseDto saved = paymentService.getStatusOfOrderId(orderId);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }
}

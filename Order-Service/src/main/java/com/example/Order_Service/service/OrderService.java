package com.example.Order_Service.service;

import com.example.Order_Service.dto.OrderRequestDto;
import com.example.Order_Service.dto.OrderResponseDto;

public interface OrderService {

     public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto);
}

package com.example.Order_Service.service;

import com.example.Order_Service.dto.OrderRequestDto;
import com.example.Order_Service.dto.OrderResponseDto;
import com.example.Order_Service.dto.OrderStatus;

import java.util.List;

public interface OrderService {


     //create
     public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto);

     //get order by id
     public OrderResponseDto getOrderById(String orderId);
     
     //get order by customer id
     public List<OrderResponseDto> getOrderByCustomerId(String customerId);

     //update order status
     public OrderResponseDto updateOrderStatus(String orderId, OrderStatus status);

}

package com.example.Order_Service.service;

import com.example.Order_Service.client.ProductClient;
import com.example.Order_Service.dto.*;
import com.example.Order_Service.entity.Order;
import com.example.Order_Service.entity.OrderItem;
import com.example.Order_Service.repository.OrderItemRepository;
import com.example.Order_Service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductClient productClient;

    public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto)
    {
         String customerId = orderRequestDto.getCustomerId();
         List<OrderItemRequestDto> items = orderRequestDto.getItems();

        Order order = new Order();
        Double totalAmount = 0.0;

        //get order items details
        List<OrderItem> orderItemList = new ArrayList<>();
        for(OrderItemRequestDto item : items)
        {
            String productId = item.getProductId();
            Integer quantity = item.getQuantity();

            ProductResponseDto productResponseDto = productClient.getProduct(productId);

            //check and update stock

            //set order items
            OrderItem orderItem = OrderItem.builder()
                    .orderId(order.getOrderId())
                    .productId(productId)
                    .quantity(quantity)
                    .price(productResponseDto.getPrice())
                    .build();
            orderItemList.add(orderItem);

            totalAmount = totalAmount + productResponseDto.getPrice();

        }

        //save order and order items
        orderRepository.save(order);
        orderItemRepository.saveAll(orderItemList);

        //send the response dto

        return OrderResponseDto.builder()
                .orderId(order.getOrderId())
                .customerId(customerId)
                .orderedDate(order.getOrderedDate())
                .status(OrderStatus.PENDING)
                .totalAmount(order.getTotalAmount())
                .items(orderItemList)
                .build();
    }
}

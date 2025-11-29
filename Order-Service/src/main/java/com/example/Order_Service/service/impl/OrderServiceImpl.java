package com.example.Order_Service.service.impl;

import com.example.Order_Service.client.ProductClient;
import com.example.Order_Service.dto.*;
import com.example.Order_Service.entity.Order;
import com.example.Order_Service.entity.OrderItem;
import com.example.Order_Service.repository.OrderItemRepository;
import com.example.Order_Service.repository.OrderRepository;
import com.example.Order_Service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductClient productClient;

    public OrderResponseDto create(OrderRequestDto orderRequestDto)
    {
         String customerId = orderRequestDto.getCustomerId();
         List<OrderItemRequestDto> items = orderRequestDto.getItems();

        Order order = new Order();
        order.setOrderId(UUID.randomUUID().toString());

        Double totalAmount = 0.0;

        //get order items details
        List<OrderItem> orderItemList = new ArrayList<>();

        for(OrderItemRequestDto item : items)
        {
            String productId = item.getProductId();
            Integer quantity = item.getQuantity();

            ProductResponseDto productResponseDto = productClient.getProduct(productId);

            //check and update stock
            if(productResponseDto.getStockQuantity() >= quantity) {
                productClient.updateStock(productId, -quantity);
            }
            else
            {
                throw new RuntimeException("out of stock");
            }

            //set order items
            OrderItem orderItem = OrderItem.builder()
                    .orderItemId(UUID.randomUUID().toString())
                    .orderId(order.getOrderId())
                    .productId(productId)
                    .quantity(quantity)
                    .price(quantity*productResponseDto.getPrice())
                    .build();
            orderItemList.add(orderItem);

            totalAmount = totalAmount + (productResponseDto.getPrice()*quantity);

        }

        //save order and order items
        order.setCustomerId(customerId);
        order.setTotalAmount(totalAmount);
        order.setStatus("PENDING");
        orderRepository.save(order);
        orderItemRepository.saveAll(orderItemList);

        //send the response dto

        return OrderResponseDto.builder()
                .orderId(order.getOrderId())
                .customerId(customerId)
                .orderedDate(order.getOrderedDate())
                .status("PENDING")
                .totalAmount(order.getTotalAmount())
                .items(orderItemList)
                .build();
    }

    @Override
    public OrderResponseDto getOrderById(String orderId) {

        Order order = orderRepository.findById(orderId).orElseThrow(()->
                new RuntimeException("order with id not found"));
        List<OrderItem> orderItemList = orderItemRepository.findByOrderId(orderId);
        return OrderResponseDto.builder()
                .orderId(orderId)
                .customerId(order.getCustomerId())
                .orderedDate(order.getOrderedDate())
                .status(order.getStatus())
                .totalAmount(order.getTotalAmount())
                .items(orderItemList)
                .build();
    }

    @Override
    public List<OrderResponseDto> getOrderByCustomerId(String customerId) {

        List<Order> orderList = orderRepository.findByCustomerId(customerId);
        List<OrderResponseDto> orderResponseDtoList = new ArrayList<>();

        for(Order order: orderList)
        {
            List<OrderItem> orderItemList = orderItemRepository.findByOrderId(order.getOrderId());
            OrderResponseDto response = OrderResponseDto.builder()
                    .orderId(order.getOrderId())
                    .customerId(order.getCustomerId())
                    .orderedDate(order.getOrderedDate())
                    .status(order.getStatus())
                    .totalAmount(order.getTotalAmount())
                    .items(orderItemList)
                    .build();
            orderResponseDtoList.add(response);
        }
        return orderResponseDtoList;
    }

    @Override
    public OrderResponseDto updateOrderStatus(OrderStatusUpdateRequestDto orderStatusUpdateRequestDto) {

        String orderId = orderStatusUpdateRequestDto.getOrderId();
        String status = orderStatusUpdateRequestDto.getStatus();

        Order order = orderRepository.findById(orderId).orElseThrow(()->
                new RuntimeException("order with id not found"));
        order.setStatus(status);
        orderRepository.save(order);
        return OrderResponseDto.builder()
                .orderId(orderId)
                .customerId(order.getCustomerId())
                .orderedDate(order.getOrderedDate())
                .status(order.getStatus())
                .totalAmount(order.getTotalAmount())
                .build();
    }
}

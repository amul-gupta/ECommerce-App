package com.example.Order_Service.controller;

import com.example.Order_Service.dto.OrderRequestDto;
import com.example.Order_Service.dto.OrderResponseDto;
import com.example.Order_Service.dto.OrderStatus;
import com.example.Order_Service.service.OrderService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //create
    @PostMapping("/create")
    public ResponseEntity<OrderResponseDto> create(@RequestBody OrderRequestDto orderRequestDto)
    {
        OrderResponseDto saved =  orderService.placeOrder(orderRequestDto);
        return new ResponseEntity<>(saved , HttpStatus.CREATED);
    }

    //get order by id
    @GetMapping("/getOrderById/{orderId}")
    public ResponseEntity<OrderResponseDto> getById(@PathVariable String orderId)
    {
        OrderResponseDto saved =  orderService.getOrderById(orderId);
        return new ResponseEntity<>(saved , HttpStatus.OK);
    }

    //get order by customer id
    @GetMapping("/getOrderByCustomerId/{orderId}")
    public ResponseEntity<List<OrderResponseDto>> getOrderByCustomerId(@PathVariable String customerId)
    {
        List<OrderResponseDto> saved =  orderService.getOrderByCustomerId(customerId);
        return new ResponseEntity<>(saved , HttpStatus.OK);
    }

    //update order status
    @PutMapping("/updateStatus")
    public ResponseEntity<OrderResponseDto> updateStatus(@PathVariable String orderId,@RequestParam OrderStatus status)
    {
        return new ResponseEntity<>(orderService.updateOrderStatus(orderId,status), HttpStatus.ACCEPTED);
    }


}

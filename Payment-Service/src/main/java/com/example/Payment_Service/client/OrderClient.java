package com.example.Payment_Service.client;

import com.example.Payment_Service.dto.OrderStatusUpdateRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OrderClient {

    @Autowired
    private RestTemplate restTemplate;


    //send request to order status update
    public void updateOrderStatus(String orderId, String status)
    {
          String url = "http://localhost:6001/order/updateStatus";
          OrderStatusUpdateRequestDto orderStatusUpdateRequestDto = new OrderStatusUpdateRequestDto();
          orderStatusUpdateRequestDto.setStatus(status);
          orderStatusUpdateRequestDto.setOrderId(orderId);
          restTemplate.put(url,orderStatusUpdateRequestDto, Order.class);

    }
}

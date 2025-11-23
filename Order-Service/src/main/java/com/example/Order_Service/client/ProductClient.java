package com.example.Order_Service.client;

import com.example.Order_Service.dto.ProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductClient {

    @Autowired
    private RestTemplate restTemplate;

    public ProductResponseDto getProduct(String productId)
    {
        String url = "http//:localhost:6000/product/" + productId;
        return restTemplate.getForObject(url,ProductResponseDto.class);
    }
}

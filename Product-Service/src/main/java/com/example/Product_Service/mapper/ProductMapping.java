package com.example.Product_Service.mapper;

import com.example.Product_Service.dto.ProductResponseDto;
import com.example.Product_Service.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapping {

    //mapper method
    public ProductResponseDto entityToDto(Product product)
    {
        return ProductResponseDto.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .stockQuantity(product.getStockQuantity())
                .isStock(product.getIsStock())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .category(product.getCategory())
                .build();
    }
}

package com.example.Product_Service.service;

import com.example.Product_Service.dto.ProductRequestDto;
import com.example.Product_Service.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {

    //create
    ProductResponseDto createProduct(ProductRequestDto productRequestDto);

    //update

    //delete

    //get all
    List<ProductResponseDto> getAllProducts();

    //get by id
    ProductResponseDto getProductById(String productId);

    //update stock
    ProductResponseDto updateStock(String productId, Integer quantity);
}

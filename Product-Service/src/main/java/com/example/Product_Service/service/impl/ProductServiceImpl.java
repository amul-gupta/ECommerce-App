package com.example.Product_Service.service.impl;


import com.example.Product_Service.dto.ProductRequestDto;
import com.example.Product_Service.dto.ProductResponseDto;
import com.example.Product_Service.entity.Category;
import com.example.Product_Service.entity.Product;
import com.example.Product_Service.mapper.ProductMapping;
import com.example.Product_Service.repository.CategoryRepository;
import com.example.Product_Service.repository.ProductRepository;
import com.example.Product_Service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductMapping productMapping;


    //create
    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        //find category
        Category category = categoryRepository.findById(productRequestDto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("catgeory not found"));

        //setting all values
        Product product = new Product();
        product.setProductId(UUID.randomUUID().toString());
        product.setName(productRequestDto.getName());
        product.setDescription(productRequestDto.getDescription());
        product.setPrice(productRequestDto.getPrice());
        product.setStockQuantity(productRequestDto.getStockQuantity());
        product.setCategory(category);

        //insert into database
        Product saved = productRepository.save(product);

        ProductResponseDto productResponseDto=  productMapping.entityToDto(saved);
        return productResponseDto;
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map( product -> {
                    return productMapping.entityToDto(product);
                }).toList();
    }

    @Override
    public ProductResponseDto getProductById(String productId) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("product not found"));

        return productMapping.entityToDto(product);
    }

    @Override
    public ProductResponseDto updateStock(String productId, Integer quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("product not found"));

        if(product.getStockQuantity()+quantity >=0 )
        product.setStockQuantity(product.getStockQuantity()+quantity);

        productRepository.save(product);
        return productMapping.entityToDto(product);
    }

}

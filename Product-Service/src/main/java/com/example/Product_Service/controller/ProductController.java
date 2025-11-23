package com.example.Product_Service.controller;

import com.example.Product_Service.dto.ProductRequestDto;
import com.example.Product_Service.dto.ProductResponseDto;
import com.example.Product_Service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    //create
    @PostMapping("/create")
    public ResponseEntity<ProductResponseDto> create(@RequestBody ProductRequestDto productRequestDto)
    {
        ProductResponseDto saved = productService.createProduct(productRequestDto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    //update

    //delete

    //get all
    @GetMapping("/getAll")
    public ResponseEntity<List<ProductResponseDto>> getAllProducts()
    {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    //get by id

}

package com.example.Product_Service.controller;

import com.example.Product_Service.dto.CategoryRequestDto;
import com.example.Product_Service.dto.CategoryResponseDto;
import com.example.Product_Service.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //create
    @PostMapping("/create")
    public ResponseEntity<CategoryResponseDto> create(@RequestBody CategoryRequestDto categoryRequestDto) {
        CategoryResponseDto saved = categoryService.createCategory(categoryRequestDto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    //update


    //delete


    //get by id


    //get all
    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryResponseDto>> getAllCategories()
    {
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }

}
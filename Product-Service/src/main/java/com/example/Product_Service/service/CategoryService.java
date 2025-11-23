package com.example.Product_Service.service;

import com.example.Product_Service.dto.CategoryRequestDto;
import com.example.Product_Service.dto.CategoryResponseDto;

import java.util.List;

public interface CategoryService {

    //create
    CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto);

    //update

    //delete

    //get all
    List<CategoryResponseDto> getAllCategories();

    //get by id
}

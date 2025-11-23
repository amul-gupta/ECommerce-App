package com.example.Product_Service.service.impl;

import com.example.Product_Service.dto.CategoryRequestDto;
import com.example.Product_Service.dto.CategoryResponseDto;
import com.example.Product_Service.entity.Category;
import com.example.Product_Service.mapper.CategoryMapping;
import com.example.Product_Service.repository.CategoryRepository;
import com.example.Product_Service.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapping categoryMapping;

    //create
    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto) {
        Category category = new Category();
        category.setName(categoryRequestDto.getName());
        category.setDescription(categoryRequestDto.getDescription());
        Category saved = categoryRepository.save(category);
        return categoryMapping.entityToDto(saved);
    }

    @Override
    public List<CategoryResponseDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(category -> categoryMapping.entityToDto(category))
                .toList();
    }

    //update


    //delete


    //get all



    //get by id

}


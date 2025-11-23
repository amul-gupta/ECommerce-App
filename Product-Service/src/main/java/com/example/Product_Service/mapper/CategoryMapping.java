package com.example.Product_Service.mapper;

import com.example.Product_Service.dto.CategoryResponseDto;
import com.example.Product_Service.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapping {

    public CategoryResponseDto entityToDto(Category category)
    {
        return CategoryResponseDto.builder()
                .name(category.getName())
                .catgeoryId(category.getCatgeoryId())
                .description(category.getDescription())
                .build();
    }
}

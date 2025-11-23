package com.example.Product_Service.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryResponseDto {

    private String catgeoryId;

    private String name;

    private String description;

}

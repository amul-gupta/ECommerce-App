package com.example.Product_Service.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    private String productId;

    private String name;

    private String description;

    private Double price;

    private Integer stockQuantity;

    private Boolean isStock;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_Id")
    private Category category;

    @PrePersist
    @PreUpdate
    public void updateStockStatus()
    {
        this.isStock = this.stockQuantity !=null && this.stockQuantity > 0;

        if(this.createdAt == null)
            this.createdAt = LocalDateTime.now();

        this.updatedAt = LocalDateTime.now();
    }

}

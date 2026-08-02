package com.finance.api.builder;

import com.finance.api.model.DTO.response.CategoryResponseDTO;
import com.finance.api.model.entity.Category;

import java.util.Random;

public class CategoryMother {

    public static Category build(){
        return Category.builder()
                .id(new Random().nextLong())
                .name("Name")
                .active(true)
                .build();
    }

    public static CategoryResponseDTO buildResponseDto(){
        return new CategoryResponseDTO(
                new Random().nextLong(),
                "name"
        );
    }
}

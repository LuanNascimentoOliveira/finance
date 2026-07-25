package com.finance.api.model.mapper;

import com.finance.api.model.DTO.response.CategoryResponseDTO;
import com.finance.api.model.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {


    CategoryResponseDTO toResponseDto(Category category);
}

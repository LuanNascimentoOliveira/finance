package com.finance.api.model.mapper;

import com.finance.api.model.DTO.response.ExpenseResponseDTO;
import com.finance.api.model.entity.Expense;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExpenseMapper {

    @Mapping(source = "categoryId.name", target = "categoryName")
    ExpenseResponseDTO toResponseDTO(Expense expense);
}

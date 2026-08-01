package com.finance.api.model.mapper;

import com.finance.api.model.DTO.response.ResumeBalanceResponseDTO;
import com.finance.api.model.DTO.response.ResumeResponseDTO;
import com.finance.api.model.entity.Expense;
import com.finance.api.model.entity.Finance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;

@Mapper(componentModel = "spring")
public interface ResumeMapper {

    @Mapping(target = "finance", source = "financialId")
    @Mapping(target = "category", source = "categoryId")
    ResumeResponseDTO toResponseDTO(Expense expense);

    ResumeBalanceResponseDTO toResumeResponseDTO(Finance finance, BigDecimal expense, BigDecimal finalBalance);
}

package com.finance.api.model.mapper;

import com.finance.api.model.DTO.response.FinanceResponseDTO;
import com.finance.api.model.entity.Finance;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FinanceMapper {

    FinanceResponseDTO toResponseDTO(Finance finance);
}

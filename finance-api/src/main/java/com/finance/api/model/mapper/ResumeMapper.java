package com.finance.api.model.mapper;

import com.finance.api.model.DTO.response.ResumeResponseDTO;
import com.finance.api.model.entity.AccountingEntry;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ResumeMapper {


    @Mapping(target = "account", source = "account")
    @Mapping(target = "category", source = "category")
    ResumeResponseDTO toResponseDTO(AccountingEntry accountingEntry);
}

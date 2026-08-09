package com.finance.api.model.mapper;

import com.finance.api.model.DTO.request.AccountingEntryRequestDTO;
import com.finance.api.model.DTO.response.AccountingEntryResponseDTO;
import com.finance.api.model.entity.AccountingEntry;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountingEntryMapper {

    AccountingEntryResponseDTO toResponseDTO(AccountingEntry accountingEntry);

    @Mapping(source = "accountId", target = "account.id")
    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(source = "accountingEntryTypeId", target = "accountingEntryType.id")
    @Mapping(target = "id", ignore = true)
    AccountingEntry toEntity(AccountingEntryRequestDTO accountingEntryRequestDTO);
}

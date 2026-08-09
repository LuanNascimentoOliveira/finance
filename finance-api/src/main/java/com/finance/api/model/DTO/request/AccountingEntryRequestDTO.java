package com.finance.api.model.DTO.request;

import java.math.BigDecimal;
import java.time.LocalDate;

public record AccountingEntryRequestDTO(
        Long accountId,
        Long categoryId,
        String description,
        BigDecimal amount,
        LocalDate postingDate,
        Long accountingEntryTypeId
) {
}

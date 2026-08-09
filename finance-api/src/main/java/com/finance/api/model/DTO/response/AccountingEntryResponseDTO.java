package com.finance.api.model.DTO.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public record AccountingEntryResponseDTO(CategoryResponseDTO category,
                                         String description,
                                         BigDecimal amount,
                                         LocalDate postingDate,
                                         AccountingEntryTypeResponseDTO accountingEntryType) {
}

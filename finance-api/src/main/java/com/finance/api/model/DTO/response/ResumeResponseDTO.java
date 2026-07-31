package com.finance.api.model.DTO.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ResumeResponseDTO(
        FinanceResponseDTO finance,
        CategoryResponseDTO category,
        BigDecimal amount,
        LocalDate expenseDate,
        String description
) {
}

package com.finance.api.model.DTO.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ExpenseResponseDTO(
        Long id,
        String categoryName,
        BigDecimal amount,
        LocalDate expenseDate,
        String description
) {
}

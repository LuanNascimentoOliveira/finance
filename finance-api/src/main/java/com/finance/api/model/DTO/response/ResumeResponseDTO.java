package com.finance.api.model.DTO.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ResumeResponseDTO(
        AccountResponseDTO account,
        CategoryResponseDTO category,
        String description,
        BigDecimal amount,
        LocalDate postingDate
) {
}

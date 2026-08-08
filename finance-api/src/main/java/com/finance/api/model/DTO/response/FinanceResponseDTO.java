package com.finance.api.model.DTO.response;

import java.math.BigDecimal;
import java.time.LocalDate;

@Deprecated
public record FinanceResponseDTO(
        Long id,
        LocalDate referenceDate,
        BigDecimal previousBalance,
        BigDecimal salary,
        BigDecimal otherEntries
) {
}

package com.finance.api.model.DTO.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ResumeBalanceResponseDTO(
        LocalDate referenceDate,
        BigDecimal previousBalance,
        BigDecimal salary,
        BigDecimal otherEntries,
        BigDecimal expense,
        BigDecimal finalBalance
) {
}

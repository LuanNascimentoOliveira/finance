package com.finance.api.model.DTO.response;

import java.math.BigDecimal;

public record AccountResponseDTO(
        Long id,
        String name,
        BigDecimal balance
) {
}

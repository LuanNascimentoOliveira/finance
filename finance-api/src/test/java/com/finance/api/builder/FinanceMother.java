package com.finance.api.builder;

import com.finance.api.model.DTO.response.FinanceResponseDTO;
import com.finance.api.model.entity.Finance;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

public class FinanceMother {

    public static Finance build(){
        return Finance.builder()
                .id(new Random().nextLong())
                .referenceDate(LocalDate.now())
                .previousBalance(BigDecimal.TEN)
                .salary(BigDecimal.valueOf(1.0))
                .otherEntries(BigDecimal.TEN)
                .build();
    }

    public static FinanceResponseDTO buildFinanceResponseDTO() {
        return new FinanceResponseDTO(
                new Random().nextLong(),
                LocalDate.now(),
                BigDecimal.TEN,
                BigDecimal.valueOf(1.0),
                BigDecimal.valueOf(0.5)
        );
    }
}

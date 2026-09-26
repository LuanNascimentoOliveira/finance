package com.finance.api.builder;

import com.finance.api.model.DTO.response.AccountingEntryResponseDTO;
import com.finance.api.model.DTO.response.AccountingEntryTypeResponseDTO;
import com.finance.api.model.DTO.response.CategoryResponseDTO;
import com.finance.api.model.entity.Account;
import com.finance.api.model.entity.AccountingEntry;
import com.finance.api.model.entity.AccountingEntryType;
import com.finance.api.model.entity.Category;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

public class StatementMother {

    public static AccountingEntry build(Category category, AccountingEntryType accountingEntryType){
        return AccountingEntry.builder()
                .id(new Random().nextLong())
                .account(Account.builder()
                        .id(new Random().nextLong())
                        .name("Name Account")
                        .balance(BigDecimal.TEN)
                        .build())
                .category(category)
                .description("Description")
                .amount(BigDecimal.TEN)
                .postingDate(LocalDate.now())
                .accountingEntryType(accountingEntryType)
                .build();
    }

    public static AccountingEntryResponseDTO buildResponseDTO(){
        return new AccountingEntryResponseDTO(
               new CategoryResponseDTO(
                       new Random().nextLong(),
                       "CAR"
               ),
                "DESCRIPTIO",
                BigDecimal.TEN,
               LocalDate.now(),
               new AccountingEntryTypeResponseDTO(
                       new Random().nextLong(),
                       "CREADITO"
               )
        );
    }
}

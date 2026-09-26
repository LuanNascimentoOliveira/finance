package com.finance.api.builder;

import com.finance.api.model.entity.AccountingEntryType;

import java.util.Random;

public class AccountingEntryTypeMother {
    public static AccountingEntryType buildCredit(){
        return AccountingEntryType.builder()
                .id(1L)
                .type("CREDIT")
                .build();
    }

    public static AccountingEntryType buildDebit(){
        return AccountingEntryType.builder()
                .id(2L)
                .type("DEBIT")
                .build();
    }
}

package com.finance.api.builder;

import com.finance.api.model.entity.AccountingEntryType;

import java.util.Random;

public class AccountingEntryTypeMother {
    public static AccountingEntryType build(){
        return AccountingEntryType.builder()
                .id(new Random().nextLong())
                .type("CREDIT")
                .build();
    }
}

package com.finance.api.builder;

import com.finance.api.model.entity.Account;

import java.math.BigDecimal;

public class AccountMother {

    public static Account build(){
        return Account.builder()
                .id(1L)
                .name("Name")
                .balance(BigDecimal.TEN)
                .build();
    }
}

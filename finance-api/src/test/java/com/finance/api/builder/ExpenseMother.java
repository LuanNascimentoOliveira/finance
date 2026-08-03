package com.finance.api.builder;

import com.finance.api.model.DTO.response.ExpenseResponseDTO;
import com.finance.api.model.entity.Category;
import com.finance.api.model.entity.Expense;
import com.finance.api.model.entity.Finance;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

public class ExpenseMother {

    public static Expense build(Category category, Finance finance){
        return Expense.builder()
                .id(new Random().nextLong())
                .financialId(finance)
                .categoryId(category)
                .amount(BigDecimal.valueOf(1.0))
                .expenseDate(LocalDate.now())
                .description("description")
                .build();
    }

    public static ExpenseResponseDTO buildResponseDTO(){
        return new ExpenseResponseDTO(
                new Random().nextLong(),
                "Car",
                BigDecimal.TEN,
                LocalDate.now(),
                "Description"
        );
    }
}

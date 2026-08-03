package com.finance.api.service;

import com.finance.api.builder.CategoryMother;
import com.finance.api.builder.ExpenseMother;
import com.finance.api.builder.FinanceMother;
import com.finance.api.model.DTO.response.ExpenseResponseDTO;
import com.finance.api.model.entity.Category;
import com.finance.api.model.entity.Expense;
import com.finance.api.model.entity.Finance;
import com.finance.api.model.mapper.ExpenseMapper;
import com.finance.api.model.service.ExpenseServiceImpl;
import com.finance.api.repository.ExpenseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExpenseServiceImplTest {

    @InjectMocks
    private ExpenseServiceImpl expenseService;

    @Mock
    private ExpenseRepository expenseRepository;

    @Mock
    private ExpenseMapper expenseMapper;

    private Expense expense;
    private Finance finance;
    private Category category;
    private ExpenseResponseDTO responseDTO;

    private final Pageable pageable = PageRequest.of(0, 10);

    @BeforeEach
    public void setUp(){
        category = CategoryMother.build();
        finance = FinanceMother.build();
        expense = ExpenseMother.build(category, finance);

        responseDTO = ExpenseMother.buildResponseDTO();
    }

    @Test
    @DisplayName("Should find all Expense")
    public void find_shouldFindAllExpense(){
        Page<Expense> expensePage = new PageImpl<>(List.of(expense), pageable, 1);

        when(expenseRepository.findAll(pageable))
                .thenReturn(expensePage);

        when(expenseMapper.toResponseDTO(expense))
                .thenReturn(responseDTO);

        Page<ExpenseResponseDTO> result = expenseService.findExpense(pageable);

        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
        assertEquals(responseDTO, result.getContent().get(0));
    }
}

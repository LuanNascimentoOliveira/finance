package com.finance.api.service;

import com.finance.api.builder.CategoryMother;
import com.finance.api.model.entity.Category;
import com.finance.api.model.mapper.AccountingEntryMapper;
import com.finance.api.model.service.StatementServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@ExtendWith(MockitoExtension.class)
public class ResumeServiceImplTest {

    @InjectMocks
    private StatementServiceImpl resumeService;

    @Mock
    private AccountingEntryMapper accountingEntryMapper;

    private Category category;

    private  final Pageable  pageable = PageRequest.of(0, 10);

    @BeforeEach
    public void setUp(){
        category = CategoryMother.build();
    }

//    @Test
//    @DisplayName("Should find all resume with balance")
//    public void find_shouldFindAllResumeWithBalance(){
//
//        when(financeRepository.findAll()).thenReturn(List.of(finance));
//        when(expenseRepository.findAll()).thenReturn(List.of(expense));
//
//    }
}

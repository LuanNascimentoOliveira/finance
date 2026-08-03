package com.finance.api.service;

import com.finance.api.builder.FinanceMother;
import com.finance.api.model.DTO.response.CategoryResponseDTO;
import com.finance.api.model.DTO.response.ExpenseResponseDTO;
import com.finance.api.model.DTO.response.FinanceResponseDTO;
import com.finance.api.model.entity.Category;
import com.finance.api.model.entity.Expense;
import com.finance.api.model.entity.Finance;
import com.finance.api.model.mapper.FinanceMapper;
import com.finance.api.model.service.FinanceServiceImpl;
import com.finance.api.repository.FinanceRepository;
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
public class FinanceServiceImplTest {

    @InjectMocks
    private FinanceServiceImpl financeService;

    @Mock
    private FinanceRepository financeRepository;

    @Mock
    private FinanceMapper financeMapper;

    private Finance finance;
    private FinanceResponseDTO financeResponseDTO;

    private final Pageable pageable = PageRequest.of(0, 10);

    @BeforeEach
    public void setUp(){
        finance = FinanceMother.build();
        financeResponseDTO = FinanceMother.buildFinanceResponseDTO();
    }

    @Test
    @DisplayName("Should find all finance")
    public void find_shouldAllFinanceAll(){
        Page<Finance> expensePage = new PageImpl<>(List.of(finance), pageable, 1);

        when(financeRepository.findAll(pageable))
                .thenReturn(expensePage);

        when(financeMapper.toResponseDTO(finance))
                .thenReturn(financeResponseDTO);

        Page<FinanceResponseDTO> result = financeService.findFinance(pageable);

        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
        assertEquals(financeResponseDTO, result.getContent().get(0));
    }
}

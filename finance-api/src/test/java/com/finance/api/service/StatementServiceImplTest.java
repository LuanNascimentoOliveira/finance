package com.finance.api.service;

import com.finance.api.builder.AccountingEntryTypeMother;
import com.finance.api.builder.CategoryMother;
import com.finance.api.builder.StatementMother;
import com.finance.api.model.DTO.response.AccountingEntryResponseDTO;
import com.finance.api.model.entity.AccountingEntry;
import com.finance.api.model.entity.AccountingEntryType;
import com.finance.api.model.entity.Category;
import com.finance.api.model.mapper.AccountingEntryMapper;
import com.finance.api.model.service.StatementServiceImpl;
import com.finance.api.repository.AccountRepository;
import com.finance.api.repository.AccountingEntryRepository;
import com.finance.api.repository.AccountingEntryTypeRepository;
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
public class StatementServiceImplTest {

    @InjectMocks
    private StatementServiceImpl statementServiceImpl;

    @Mock
    private AccountingEntryRepository accountingEntryRepository;

    @Mock
    private AccountingEntryTypeRepository accountingEntryTypeRepository;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private AccountingEntryMapper accountingEntryMapper;

    private AccountingEntry accountingEntry;
    private AccountingEntryResponseDTO accountingEntryResponseDTO;

    private final Pageable  pageable = PageRequest.of(0, 10);

    @BeforeEach
    public void setUp(){
        Category category = CategoryMother.build();
        AccountingEntryType accountingEntryType = AccountingEntryTypeMother.build();

        accountingEntry = StatementMother.build(category, accountingEntryType);

        accountingEntryResponseDTO = StatementMother.buildResponseDTO();
    }

    @Test
    @DisplayName("Should find all account entry")
    public void find_shouldFindAllAccountingEntry(){
        Page<AccountingEntry> accountingEntryPage = new PageImpl<>(List.of(accountingEntry));

        when(accountingEntryRepository.findAll(pageable)).thenReturn(accountingEntryPage);
        when(accountingEntryMapper.toResponseDTO(accountingEntry)).thenReturn(accountingEntryResponseDTO);

        Page<AccountingEntryResponseDTO> result = statementServiceImpl.findAllAccountingEntry(pageable);

        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
        assertEquals(accountingEntryResponseDTO, result.getContent().get(0));
    }

    @Test
    @DisplayName("Should add new account entry by account id")
    public void find_shouldFindAllResumeWithBalance(){



    }
}

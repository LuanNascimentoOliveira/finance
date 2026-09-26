package com.finance.api.service;

import com.finance.api.builder.AccountMother;
import com.finance.api.builder.AccountingEntryTypeMother;
import com.finance.api.builder.CategoryMother;
import com.finance.api.builder.StatementMother;
import com.finance.api.model.DTO.request.AccountingEntryRequestDTO;
import com.finance.api.model.DTO.response.AccountingEntryResponseDTO;
import com.finance.api.model.entity.Account;
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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
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
    private AccountingEntryType accountingEntryType;
    private Account account;
    private Category category;

    private AccountingEntryResponseDTO accountingEntryResponseDTO;
    private AccountingEntryRequestDTO accountingEntryRequestDTO;


    private final Pageable  pageable = PageRequest.of(0, 10);

    @BeforeEach
    public void setUp(){
        category = CategoryMother.build();
        accountingEntryType = AccountingEntryTypeMother.buildCredit();
        account = AccountMother.build();
        accountingEntry = StatementMother.build(account, category, accountingEntryType);
        accountingEntryRequestDTO = StatementMother.buildRequestDTO();
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
    @DisplayName("Add new Account Entry and update balance for credit")
    public void add_newAccountEntryAndUpdateBalanceForCredit(){
        Long EntryType = 1L;
        Long accountId = 1L;
        accountingEntryType = AccountingEntryTypeMother.buildCredit();
        accountingEntry = StatementMother.build(account, category, accountingEntryType);

        when(accountingEntryMapper.toEntity(accountingEntryRequestDTO)).thenReturn(accountingEntry);
        when(accountingEntryTypeRepository.findById(EntryType)).thenReturn(Optional.ofNullable(accountingEntryType));
        when(accountRepository.findById(accountId)).thenReturn(Optional.ofNullable(account));

        statementServiceImpl.addNewAccountingEntryByAccountId(accountingEntryRequestDTO);

        verify(accountingEntryRepository).save(accountingEntry);
    }

    @Test
    @DisplayName("Add new Account Entry and update balance for debit")
    public void add_newAccountEntryAndUpdateBalanceForDebit(){
        Long EntryType = 2L;
        Long accountId = 1L;

        accountingEntryType = AccountingEntryTypeMother.buildDebit();
        accountingEntry = StatementMother.build(account, category, accountingEntryType);

        when(accountingEntryMapper.toEntity(accountingEntryRequestDTO)).thenReturn(accountingEntry);
        when(accountingEntryTypeRepository.findById(EntryType)).thenReturn(Optional.ofNullable(accountingEntryType));
        when(accountRepository.findById(accountId)).thenReturn(Optional.ofNullable(account));

        statementServiceImpl.addNewAccountingEntryByAccountId(accountingEntryRequestDTO);

        verify(accountingEntryRepository).save(accountingEntry);
    }
}

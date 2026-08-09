package com.finance.api.model.service;

import com.finance.api.model.DTO.request.AccountingEntryRequestDTO;
import com.finance.api.model.DTO.response.AccountingEntryResponseDTO;
import com.finance.api.model.entity.Account;
import com.finance.api.model.entity.AccountingEntry;
import com.finance.api.model.entity.AccountingEntryType;
import com.finance.api.model.enums.AccountingEntryTypeEnum;
import com.finance.api.model.mapper.AccountingEntryMapper;
import com.finance.api.model.service.imp.StatementService;
import com.finance.api.repository.AccountRepository;
import com.finance.api.repository.AccountingEntryRepository;
import com.finance.api.repository.AccountingEntryTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class StatementServiceImpl implements StatementService {

    private final AccountingEntryRepository accountingEntryRepository;
    private final AccountingEntryTypeRepository accountingEntryTypeRepository;
    private final AccountRepository accountRepository;

    private final AccountingEntryMapper accountingEntryMapper;

    @Override
    @Transactional(readOnly = true)
    public Page<AccountingEntryResponseDTO> findAllAccountingEntry(Pageable pageable) {
        return accountingEntryRepository.findAll(pageable).map(accountingEntryMapper::toResponseDTO);
    }

    @Override
    @Transactional
    public void addNewAccountingEntryByAccountId(AccountingEntryRequestDTO accountingEntryRequestDTO) {

        AccountingEntry accountingEntry = accountingEntryMapper.toEntity(accountingEntryRequestDTO);

        updateAccountBalance(
                accountingEntry.getAccount().getId(),
                accountingEntry.getAmount(),
                accountingEntry.getAccountingEntryType().getId());

        accountingEntryRepository.save(accountingEntry);
    }

    private void updateAccountBalance(Long accountId, BigDecimal amount, Long typeId) {

        AccountingEntryType accountingEntryType  = accountingEntryTypeRepository.findById(typeId)
                .orElseThrow(() ->
                        new RuntimeException("Accounting entry type not found")
                );

        Account account  = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

            switch (AccountingEntryTypeEnum.valueOf(accountingEntryType.getType())) {
                case CREDIT -> account.setBalance(account.getBalance().add(amount));
                case DEBIT -> account.setBalance(account.getBalance().subtract(amount));
            }
    }
}

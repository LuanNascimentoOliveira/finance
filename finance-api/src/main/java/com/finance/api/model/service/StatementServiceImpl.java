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
import java.util.Optional;

import static com.finance.api.model.enums.AccountingEntryTypeEnum.CREDIT;
import static com.finance.api.model.enums.AccountingEntryTypeEnum.DEBIT;

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

        Optional<AccountingEntryType> findAccountingEntryType = accountingEntryTypeRepository.findById(accountingEntry.getAccountingEntryType().getId());

        if(findAccountingEntryType.isPresent()){

            switch (AccountingEntryTypeEnum.valueOf(findAccountingEntryType.get().getType())){
                case CREDIT -> updateAccountBalance(accountingEntry.getAccount().getId(), accountingEntry.getAmount(), CREDIT);
                case DEBIT -> updateAccountBalance(accountingEntry.getAccount().getId(), accountingEntry.getAmount(), DEBIT);
            }
        }

        accountingEntryRepository.save(accountingEntry);
    }

    private void updateAccountBalance(Long accountId, BigDecimal amount, AccountingEntryTypeEnum type) {

        Optional<Account> findAccount = accountRepository.findById(accountId);

        if(findAccount.isPresent()) {
            switch (type) {
                case CREDIT -> findAccount.get().setBalance(findAccount.get().getBalance().add(amount));
                case DEBIT -> findAccount.get().setBalance(findAccount.get().getBalance().subtract(amount));
            }
        }
    }


}

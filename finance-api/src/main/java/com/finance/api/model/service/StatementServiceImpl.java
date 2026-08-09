package com.finance.api.model.service;

import com.finance.api.model.DTO.request.AccountingEntryRequestDTO;
import com.finance.api.model.DTO.response.AccountingEntryResponseDTO;
import com.finance.api.model.entity.AccountingEntry;
import com.finance.api.model.entity.AccountingEntryType;
import com.finance.api.model.enums.AccountingEntryTypeEnum;
import com.finance.api.model.mapper.AccountingEntryMapper;
import com.finance.api.model.service.imp.StatementService;
import com.finance.api.repository.AccountingEntryRepository;
import com.finance.api.repository.AccountingEntryTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StatementServiceImpl implements StatementService {

    private final AccountingEntryRepository accountingEntryRepository;
    private final AccountingEntryTypeRepository accountingEntryTypeRepository;

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

//        Optional<AccountingEntryType> findAccountingEntryType = accountingEntryTypeRepository.findById(accountingEntry.getAccountingEntryType().getId());
//
//        if(findAccountingEntryType.isPresent()){
//
//            if (AccountingEntryTypeEnum.valueOf(findAccountingEntryType.get().getType()) == AccountingEntryTypeEnum.CREDIT) {
//
//            }
//        }

        accountingEntryRepository.save(accountingEntry);
    }


}

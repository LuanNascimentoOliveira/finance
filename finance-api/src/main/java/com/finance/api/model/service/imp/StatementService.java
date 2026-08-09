package com.finance.api.model.service.imp;


import com.finance.api.model.DTO.request.AccountingEntryRequestDTO;
import com.finance.api.model.DTO.response.AccountingEntryResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StatementService {

    Page<AccountingEntryResponseDTO> findAllAccountingEntry(Pageable pageable);

    void addNewAccountingEntryByAccountId(AccountingEntryRequestDTO accountingEntryRequestDTO);
}

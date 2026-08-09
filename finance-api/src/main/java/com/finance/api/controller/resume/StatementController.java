package com.finance.api.controller.resume;

import com.finance.api.model.DTO.request.AccountingEntryRequestDTO;
import com.finance.api.model.DTO.response.AccountingEntryResponseDTO;
import com.finance.api.model.service.imp.StatementService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/statement")
public class StatementController {

    private final StatementService statementService;

    @GetMapping
    public Page<AccountingEntryResponseDTO> findAll(Pageable pageable){

        return statementService.findAllAccountingEntry(pageable);
    }

    @PostMapping
    public ResponseEntity<Void> addNewAccountingEntryByAccountId(@RequestBody AccountingEntryRequestDTO accountingEntryRequestDTO){
        statementService.addNewAccountingEntryByAccountId(accountingEntryRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

package com.finance.api.controller.expense;

import com.finance.api.model.DTO.response.ExpenseResponseDTO;
import com.finance.api.model.service.imp.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/expenses")
public class ExpenseController {

    private final ExpenseService expenseServiceImp;

    @GetMapping
    public Page<ExpenseResponseDTO> findAll(Pageable pageable){
        return expenseServiceImp.findExpense(pageable);
    }
}

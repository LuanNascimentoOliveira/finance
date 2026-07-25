package com.finance.api.model.service.imp;

import com.finance.api.model.DTO.response.ExpenseResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ExpenseService {

    Page<ExpenseResponseDTO> findExpense(Pageable pageable);
}

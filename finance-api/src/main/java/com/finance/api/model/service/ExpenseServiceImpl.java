package com.finance.api.model.service;

import com.finance.api.model.DTO.response.ExpenseResponseDTO;
import com.finance.api.model.mapper.ExpenseMapper;
import com.finance.api.model.service.imp.ExpenseService;
import com.finance.api.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ExpenseMapper expenseMapper;

    @Transactional(readOnly = true)
    @Override
    public Page<ExpenseResponseDTO> findExpense(Pageable pageable) {
        return expenseRepository.findAll(pageable).map(expenseMapper::toResponseDTO);
    }
}

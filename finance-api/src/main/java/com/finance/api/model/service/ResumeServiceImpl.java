package com.finance.api.model.service;

import com.finance.api.model.DTO.response.ResumeResponseDTO;
import com.finance.api.model.entity.Expense;
import com.finance.api.model.mapper.ResumeMapper;
import com.finance.api.model.service.imp.ResumeService;
import com.finance.api.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService {

    private final ExpenseRepository expenseRepository;
    private final ResumeMapper resumeMapper;

    @Override
    public Page<ResumeResponseDTO> findAllResume(Pageable pageable) {
        return expenseRepository.findAll(pageable).map(resumeMapper::toResponseDTO);
    }
}

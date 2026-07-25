package com.finance.api.model.service;

import com.finance.api.model.DTO.response.FinanceResponseDTO;
import com.finance.api.model.mapper.FinanceMapper;
import com.finance.api.model.service.imp.FinanceService;
import com.finance.api.repository.FinanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FinanceServiceImpl implements FinanceService {

    private final FinanceRepository financeRepository;
    private final FinanceMapper financeMapper;

    @Transactional(readOnly = true)
    @Override
    public Page<FinanceResponseDTO> findFinance(Pageable pageable) {
        return financeRepository.findAll(pageable).map(financeMapper::toResponseDTO);
    }
}

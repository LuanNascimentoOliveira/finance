package com.finance.api.model.service.imp;

import com.finance.api.model.DTO.response.FinanceResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FinanceService {

    Page<FinanceResponseDTO> findFinance(Pageable pageable);
}

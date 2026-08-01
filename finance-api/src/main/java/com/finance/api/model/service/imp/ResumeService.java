package com.finance.api.model.service.imp;

import com.finance.api.model.DTO.response.ResumeBalanceResponseDTO;
import com.finance.api.model.DTO.response.ResumeResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ResumeService {

    Page<ResumeResponseDTO> findAllResume(Pageable pageable);
    Page<ResumeBalanceResponseDTO> findAllResumeWithBalance(Pageable pageable);
}

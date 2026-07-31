package com.finance.api.model.service.imp;

import com.finance.api.model.DTO.response.ResumeResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface ResumeService {

    Page<ResumeResponseDTO> findAllResume(Pageable pageable);
}

package com.finance.api.model.service;

import com.finance.api.model.DTO.response.ResumeResponseDTO;
import com.finance.api.model.mapper.ResumeMapper;
import com.finance.api.model.service.imp.ResumeService;
import com.finance.api.repository.AccountingEntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService {

    private final AccountingEntryRepository accountingEntryRepository;

    private final ResumeMapper resumeMapper;

    @Override
    @Transactional(readOnly = true)
    public Page<ResumeResponseDTO> findAllResume(Pageable pageable) {
        return accountingEntryRepository.findAll(pageable).map(resumeMapper::toResponseDTO);
    }


}

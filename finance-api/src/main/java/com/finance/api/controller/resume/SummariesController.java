package com.finance.api.controller.resume;

import com.finance.api.model.DTO.response.ResumeBalanceResponseDTO;
import com.finance.api.model.DTO.response.ResumeResponseDTO;
import com.finance.api.model.service.imp.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/resumes")
public class SummariesController {

    private final ResumeService resumeService;

    @GetMapping
    public Page<ResumeResponseDTO> findAll(Pageable pageable){

        return resumeService.findAllResume(pageable);

    }

    @GetMapping("/balances")
    public Page<ResumeBalanceResponseDTO> findAllResumeBalance(Pageable pageable){

        return resumeService.findAllResumeWithBalance(pageable);
    }
}

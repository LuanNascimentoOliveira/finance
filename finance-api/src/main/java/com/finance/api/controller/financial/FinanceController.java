package com.finance.api.controller.financial;

import com.finance.api.model.DTO.response.FinanceResponseDTO;
import com.finance.api.model.service.imp.FinanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/financiers")
@RequiredArgsConstructor
public class FinanceController {

    private final FinanceService financeServiceImp;

    @GetMapping()
    public Page<FinanceResponseDTO> findAll(Pageable pageable){
        return financeServiceImp.findFinance(pageable);
    }


}

package com.finance.api.model.service;

import com.finance.api.model.DTO.response.ResumeBalanceResponseDTO;
import com.finance.api.model.DTO.response.ResumeResponseDTO;
import com.finance.api.model.entity.Expense;
import com.finance.api.model.entity.Finance;
import com.finance.api.model.mapper.ResumeMapper;
import com.finance.api.model.service.imp.ResumeService;
import com.finance.api.repository.ExpenseRepository;
import com.finance.api.repository.FinanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService {

    private final ExpenseRepository expenseRepository;
    private final FinanceRepository financeRepository;
    private final ResumeMapper resumeMapper;

    @Override
    public Page<ResumeResponseDTO> findAllResume(Pageable pageable) {
        return expenseRepository.findAll(pageable).map(resumeMapper::toResponseDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ResumeBalanceResponseDTO> findAllResumeWithBalance(Pageable pageable) {

        List<Finance> findFinance = financeRepository.findAll();

        Map<YearMonth, BigDecimal> expensesByMonth = totalAmountByMonth();

        List<ResumeBalanceResponseDTO> resumes = findFinance.stream()
                .map(finance -> {
                    YearMonth yearMonth = YearMonth.from(finance.getReferenceDate());

                    BigDecimal expense = expensesByMonth.getOrDefault(
                            yearMonth,
                            BigDecimal.ZERO
                    );

                    BigDecimal balanceByMonth = defaultValue(finance.getPreviousBalance())
                            .add(finance.getSalary())
                            .add(finance.getOtherEntries())
                            .subtract(expense);

                    return resumeMapper.toResumeResponseDTO(finance, expense, balanceByMonth);

                }).toList();

        return listToPageable(resumes, pageable);
    }

    private Map<YearMonth, BigDecimal> totalAmountByMonth() {

        List<Expense> findExpense = expenseRepository.findAll();

        return findExpense.stream()
                .collect(Collectors.groupingBy(
                        totalAmountByMonth -> YearMonth.from(totalAmountByMonth.getExpenseDate()),
                        Collectors.reducing(
                                BigDecimal.ZERO,
                                Expense::getAmount,
                                BigDecimal::add)
                ));
    }

    private BigDecimal defaultValue(BigDecimal value) {
        return value != null ? value : BigDecimal.ZERO;
    }

    private Page<ResumeBalanceResponseDTO> listToPageable(List<ResumeBalanceResponseDTO> resumes, Pageable pageable) {

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), resumes.size());

        List<ResumeBalanceResponseDTO> pageContent = resumes.subList(start, end);

        return new PageImpl<>(
                pageContent,
                pageable,
                resumes.size()
        );
    }
}

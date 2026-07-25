package com.finance.api.repository;

import com.finance.api.model.entity.Finance;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FinanceRepository extends JpaRepository<Finance, Long>{
}

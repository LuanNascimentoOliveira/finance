package com.finance.api.repository;

import com.finance.api.model.entity.AccountingEntryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountingEntryTypeRepository extends JpaRepository<AccountingEntryType, Long> {
}

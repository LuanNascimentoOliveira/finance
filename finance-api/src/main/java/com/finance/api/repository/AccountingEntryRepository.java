package com.finance.api.repository;

import com.finance.api.model.entity.AccountingEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountingEntryRepository extends JpaRepository<AccountingEntry, Long> {
}

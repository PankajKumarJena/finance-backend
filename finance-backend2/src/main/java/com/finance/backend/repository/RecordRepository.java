package com.finance.backend.repository;

import com.finance.backend.model.FinancialRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<FinancialRecord, Long> {
}

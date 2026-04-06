package com.finance.dashboard.repository;

import com.finance.dashboard.entity.FinancialRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RecordRepository extends JpaRepository<FinancialRecord, Long> {

    List<FinancialRecord> findByDeletedFalse();

    Page<FinancialRecord> findByDeletedFalse(Pageable pageable);

    Page<FinancialRecord> findByTypeIgnoreCaseAndDeletedFalse(String type, Pageable pageable);

    Page<FinancialRecord> findByCategoryIgnoreCaseAndDeletedFalse(String category, Pageable pageable);

    Page<FinancialRecord> findByDateBetweenAndDeletedFalse(LocalDate start, LocalDate end, Pageable pageable);

    Page<FinancialRecord> findByTypeAndCategoryAllIgnoreCaseAndDeletedFalse(String type, String category, Pageable pageable);
}
package com.finance.dashboard.service;

import com.finance.dashboard.dto.RecordDTO;
import com.finance.dashboard.entity.FinancialRecord;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RecordService {

    FinancialRecord create(RecordDTO dto);

    List<FinancialRecord> getAll();

    FinancialRecord update(Long id, RecordDTO dto);

    void delete(Long id);

    Page<FinancialRecord> getFilteredRecords(
            String type,
            String category,
            String startDate,
            String endDate,
            int page,
            int size
    );
}
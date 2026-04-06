package com.finance.dashboard.service.impl;

import com.finance.dashboard.dto.DashboardResponse;
import com.finance.dashboard.entity.FinancialRecord;
import com.finance.dashboard.repository.RecordRepository;
import com.finance.dashboard.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final RecordRepository repo;

    @Override
    public DashboardResponse getSummary() {
        List<FinancialRecord> records = repo.findByDeletedFalse();

        double income = 0, expense = 0;

        for (FinancialRecord r : records) {
            if ("INCOME".equalsIgnoreCase(r.getType()))
                income += r.getAmount();
            else
                expense += r.getAmount();
        }

        return DashboardResponse.builder()
                .totalIncome(income)
                .totalExpense(expense)
                .netBalance(income - expense)
                .build();
    }
}

package com.finance.dashboard.service.impl;

import com.finance.dashboard.dto.RecordDTO;
import com.finance.dashboard.entity.FinancialRecord;
import com.finance.dashboard.exception.ResourceNotFoundException;
import com.finance.dashboard.mapper.RecordMapper;
import com.finance.dashboard.repository.RecordRepository;
import com.finance.dashboard.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordServiceImpl implements RecordService {

    private final RecordRepository repo;

    @Override
    public FinancialRecord create(RecordDTO dto) {
        return repo.save(RecordMapper.toEntity(dto));
    }

    @Override
    public List<FinancialRecord> getAll() {
        return repo.findByDeletedFalse();
    }

    @Override
    public FinancialRecord update(Long id, RecordDTO dto) {
        FinancialRecord record = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found"));

        record.setAmount(dto.getAmount());
        record.setCategory(dto.getCategory());
        record.setType(dto.getType());
        record.setDate(dto.getDate());
        record.setDescription(dto.getDescription());

        return repo.save(record);
    }


    @Override
    public Page<FinancialRecord> getFilteredRecords(
            String type,
            String category,
            String startDate,
            String endDate,
            int page,
            int size
    ) {

        Pageable pageable = PageRequest.of(page, size);

        // Priority-based filtering logic
        if (type != null && category != null) {
            return repo.findByTypeAndCategoryAllIgnoreCaseAndDeletedFalse(type, category, pageable);
        }

        if (type != null) {
            return repo.findByTypeIgnoreCaseAndDeletedFalse(type, pageable);
        }

        if (category != null) {
            return repo.findByCategoryIgnoreCaseAndDeletedFalse(category, pageable);
        }

        if (startDate != null && endDate != null) {
            return repo.findByDateBetweenAndDeletedFalse(
                    LocalDate.parse(startDate),
                    LocalDate.parse(endDate),
                    pageable
            );
        }

        return repo.findByDeletedFalse(pageable);
    }

    @Override
    public void delete(Long id) {
        FinancialRecord record = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found"));

        record.setDeleted(true);
        repo.save(record);
    }
}
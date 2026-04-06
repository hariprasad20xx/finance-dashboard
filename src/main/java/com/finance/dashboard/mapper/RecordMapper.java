package com.finance.dashboard.mapper;

import com.finance.dashboard.dto.RecordDTO;
import com.finance.dashboard.entity.FinancialRecord;

public class RecordMapper {

    public static FinancialRecord toEntity(RecordDTO dto) {
        return FinancialRecord.builder()
                .amount(dto.getAmount())
                .type(dto.getType())
                .category(dto.getCategory())
                .date(dto.getDate())
                .description(dto.getDescription())
                .build();
    }
}

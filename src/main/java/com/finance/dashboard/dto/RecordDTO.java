package com.finance.dashboard.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RecordDTO {
    private Double amount;
    private String type;
    private String category;
    private LocalDate date;
    private String description;
}

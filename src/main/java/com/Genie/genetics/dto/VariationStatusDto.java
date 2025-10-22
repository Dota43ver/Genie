package com.Genie.genetics.dto;

import lombok.Data;

@Data
public class VariationStatusDto {
    private Boolean isActive;
    private Double avgScore;
    private Integer useCount;
}
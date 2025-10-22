package com.Genie.genetics.dto;

import lombok.Data;
@Data
public class VariationDto {
    private String variationId;
    private String agentId;
    private int generation;
    private String promptText;
    private boolean isActive;
    private Double avgScore;
    private Integer useCount;
    private String parentIds;
    private String mutationApplied;
}
package com.Genie.genetics.dto;

import lombok.Data;
import java.time.LocalDateTime;
@Data
public class WinnerDto {
    private String winnerId;
    private String agentId;
    private String variationId;
    private String promptText;
    private int generationWon;
    private Double finalAvgScore;
    private LocalDateTime selectionDate;
}
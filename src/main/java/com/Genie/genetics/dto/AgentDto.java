package com.Genie.genetics.dto;

import lombok.Data;
@Data
public class AgentDto {
    private String agentId;
    private String basePrompt;
    private String agentName;
    private int activeGeneration;
    private int populationSize;
}

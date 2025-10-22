package com.Genie.genetics.dto;

import lombok.Data;
@Data
public class RequestDto {
    private String requestId;
    private String agentId;
    private String variationId;
    private Double score;
    private String promptText;
    private String userRequest;
    private String generatedContent;
}

package com.Genie.genetics.service;

import com.Genie.genetics.dto.*;
import com.Genie.genetics.entity.Agent;
import com.Genie.genetics.entity.Request;
import com.Genie.genetics.entity.Variation;
import com.Genie.genetics.entity.Winner;
import com.Genie.genetics.repository.AgentRepository;
import com.Genie.genetics.repository.RequestRepository;
import com.Genie.genetics.repository.VariationRepository;
import com.Genie.genetics.repository.WinnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class GeneticService {

    private final AgentRepository agentRepo;
    private final VariationRepository variationRepo;
    private final RequestRepository requestRepo;
    private final WinnerRepository winnerRepo;

    public Agent createAgent(AgentDto dto) {
        Agent agent = Agent.builder()
                .agentId(dto.getAgentId())
                .agentName(dto.getAgentName())
                .basePrompt(dto.getBasePrompt())
                .activeGeneration(dto.getActiveGeneration())
                .populationSize(dto.getPopulationSize())
                .build();
        return agentRepo.save(agent);
    }

    public Agent getAgent(String agentId) {
        return agentRepo.findByAgentId(agentId).orElseThrow(() -> new NoSuchElementException("Agent not found"));
    }

    public List<Agent> getAllAgents() {
        return agentRepo.findAll();
    }

    public Agent updateAgent(String agentId, AgentDto dto) {
        Agent agent = getAgent(agentId);
        agent.setAgentName(dto.getAgentName());
        agent.setBasePrompt(dto.getBasePrompt());
        agent.setActiveGeneration(dto.getActiveGeneration());
        agent.setPopulationSize(dto.getPopulationSize());
        return agentRepo.save(agent);
    }

    private Agent findAgentByAgentId(String agentId) {
        return agentRepo.findByAgentId(agentId).orElseThrow(() -> new NoSuchElementException("Agent " + agentId + " not found"));
    }

    public Variation createVariation(VariationDto dto) {
        Agent agent = findAgentByAgentId(dto.getAgentId());
        Variation variation = Variation.builder()
                .variationId(dto.getVariationId())
                .agent(agent)
                .generation(dto.getGeneration())
                .promptText(dto.getPromptText())
                .isActive(dto.isActive())
                .avgScore(dto.getAvgScore())
                .useCount(dto.getUseCount())
                .parentIds(dto.getParentIds())
                .mutationApplied(dto.getMutationApplied())
                .build();
        return variationRepo.save(variation);
    }

    public Variation getVariation(String variationId) {
        return variationRepo.findByVariationId(variationId).orElseThrow(() -> new NoSuchElementException("Variation not found"));
    }

    public List<Variation> getAllVariations() {
        return variationRepo.findAll();
    }

    private Variation findVariationByVariationId(String variationId) {
        return variationRepo.findByVariationId(variationId).orElseThrow(() -> new NoSuchElementException("Variation " + variationId + " not found"));
    }

    public Request createRequest(RequestDto dto) {
        Agent agent = findAgentByAgentId(dto.getAgentId());
        Variation variation = findVariationByVariationId(dto.getVariationId());
        Request request = Request.builder()
                .requestId(dto.getRequestId())
                .agent(agent)
                .variation(variation)
                .score(dto.getScore())
                .promptText(dto.getPromptText())
                .userRequest(dto.getUserRequest())
                .generatedContent(dto.getGeneratedContent())
                .build();
        return requestRepo.save(request);
    }

    public Request getRequest(String requestId) {
        return requestRepo.findByRequestId(requestId).orElseThrow(() -> new NoSuchElementException("Request not found"));
    }

    public List<Request> getAllRequests() {
        return requestRepo.findAll();
    }

    public Winner createWinner(WinnerDto dto) {
        Agent agent = findAgentByAgentId(dto.getAgentId());
        Variation variation = findVariationByVariationId(dto.getVariationId());
        Winner winner = Winner.builder()
                .winnerId(dto.getWinnerId())
                .agent(agent)
                .variation(variation)
                .promptText(dto.getPromptText())
                .generationWon(dto.getGenerationWon())
                .finalAvgScore(dto.getFinalAvgScore())
                .selectionDate(dto.getSelectionDate())
                .build();
        return winnerRepo.save(winner);
    }

    public Winner getWinner(String winnerId) {
        return winnerRepo.findByWinnerId(winnerId).orElseThrow(() -> new NoSuchElementException("Winner not found"));
    }

    public List<Winner> getAllWinners() {
        return winnerRepo.findAll();
    }

    public Agent updateAgentStatus(String agentId, AgentStatusDto dto) {
        Agent agent = getAgent(agentId);
        agent.setActiveGeneration(dto.getActiveGeneration());
        return agentRepo.save(agent);
    }

    public Variation updateVariationStatus(String variationId, VariationStatusDto dto) {
        Variation variation = getVariation(variationId);


        if (dto.getIsActive() != null) {
            variation.setActive(dto.getIsActive());
        }
        if (dto.getAvgScore() != null) {
            variation.setAvgScore(dto.getAvgScore());
        }
        if (dto.getUseCount() != null) {
            variation.setUseCount(dto.getUseCount());
        }
        return variationRepo.save(variation);
    }

    public Request updateRequestScore(String requestId, RequestScoreDto dto) {
        Request request = getRequest(requestId);
        request.setScore(dto.getScore());
        return requestRepo.save(request);
    }
}
